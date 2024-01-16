package com.spring.writable.framework.context.support;

import com.spring.writable.framework.beans.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Description： 对配置文件进行查找、读取、分析
 *
 * @author: 段世超
 * @aate: Created in 2024/1/16 9:46
 */
public class GPBeanDefinitionReader {

   private List<String> registryBeanClass =  new ArrayList<String>();

   private Properties config = new Properties();

   // 固定配置文件中的key,
    private final String SCAN_PACKAGE="scanPackage";

    public GPBeanDefinitionReader(String... locations){
        // 通过URL定位找到其所对应的文件，然后转换为流
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:", ""));

        try{
            config.load(is);
        }catch (Exception e){

            e.printStackTrace();

        }finally {
            if (null!=is){
                try {
                    is.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String scanPackage) {

        //转换为文件路径
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classpath = new File(url.getFile());
        for (File file : classpath.listFiles()) {

            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            }
            else {
                if (!file.getName().endsWith(".class")){continue;}
                String className = (scanPackage+"."+file.getName().replace(".class",""));
                registryBeanClass.add(className);
            }
        }
    }
    public Properties getConfig(){
        return this.config;
    }
    // 把配置文件中扫描到的所有配置信息转化为GPBeanDefinition对象，便于之后的IOC操作
    public List<GPBeanDefinition> loadBeanDefinitions(){

        List<GPBeanDefinition> result = new ArrayList<>();

        try {
            for (String className : registryBeanClass) {
                Class<?> beanClass = Class.forName(className);
                if (beanClass.isInterface()){
                    continue;
                }
                result.add(doCreateBeanDefinition(beanClass.getSimpleName(),beanClass.getName()));
                Class<?>[] interfaces = beanClass.getInterfaces();
                for (Class<?> i : interfaces) {
                    result.add(doCreateBeanDefinition(i.getName(),beanClass.getName()));
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private GPBeanDefinition doCreateBeanDefinition(String factoryBeanName,String beanClassName) {

        GPBeanDefinition beanDefinition = new GPBeanDefinition();

        beanDefinition.setBeanClassName(beanClassName);
        beanDefinition.setFactoryBeanName(factoryBeanName);
        return beanDefinition;
    }
     private String toLowerFirstCase(String simpleName){

         char[] chars = simpleName.toCharArray();
         chars[0]+=32;
         return String.valueOf(chars);
     }

}
