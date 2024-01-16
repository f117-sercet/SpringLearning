package com.spring.writable.framework.context;

import com.spring.writable.framework.beans.GPBeanDefinition;
import com.spring.writable.framework.beans.GPBeanWrapper;
import com.spring.writable.framework.context.support.GPAbstractApplicationContext;
import com.spring.writable.framework.context.support.GPBeanDefinitionReader;
import com.spring.writable.framework.context.support.GPDefaultListableBeanFactory;
import com.spring.writable.framework.core.GPBeanFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/16 9:40
 */
public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory {

    private String[] configLocations;
    private GPBeanDefinitionReader reader;
    
    // 单例的IOC容器缓存
    private Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String,Object>();
    //通用的IOC模块
    private Map<String, GPBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<String,GPBeanWrapper>();
    
    public GPApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        try{
            refresh();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public Object getBean(Class<?> beanClass) throws Exception {
        return null;
    }

    @Override
    public void refresh() throws Exception {
        //1.定位，定位配置文件
        reader  = new GPBeanDefinitionReader(this.configLocations);
        
        //2.加载配置文件
        List<GPBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();
        
        //3.注册，把配置信息放到容器里
        doRegisterBeanDefinition(beanDefinitions);
        //4.把不是延时加载的       类提前初始化
        doAutowrited();
    }

    private void doAutowrited() {
    }

    private void doRegisterBeanDefinition(List<GPBeanDefinition> beanDefinitions) {
    }
}
