package com.spring.writable.framework.context;

import com.spring.writable.annotation.GPAutowired;
import com.spring.writable.annotation.GPController;
import com.spring.writable.annotation.GPService;
import com.spring.writable.framework.beans.GPBeanDefinition;
import com.spring.writable.framework.beans.GPBeanWrapper;
import com.spring.writable.framework.beans.config.GPBeanPostProcessor;
import com.spring.writable.framework.context.support.GPAbstractApplicationContext;
import com.spring.writable.framework.context.support.GPBeanDefinitionReader;
import com.spring.writable.framework.context.support.GPDefaultListableBeanFactory;
import com.spring.writable.framework.core.GPBeanFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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
    private Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();
    //通用的IOC模块
    private Map<String, GPBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<String, GPBeanWrapper>();

    public GPApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refresh() throws Exception {
        //1.定位，定位配置文件
        reader = new GPBeanDefinitionReader(this.configLocations);

        //2.加载配置文件
        List<GPBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();

        //3.注册，把配置信息放到容器里
        doRegisterBeanDefinition(beanDefinitions);
        //4.把不是延时加载的 类提前初始化
        doAutowrited();
    }

    // 只处理非延时加载的情况

    private void doAutowrited() throws IllegalAccessException {
        for (Map.Entry<String, GPBeanDefinition> beanDefinitionEntry : beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            if (!beanDefinitionEntry.getValue().isLazyInit()) {
                getBean(beanName);

            }
        }
    }

    private void doRegisterBeanDefinition(List<GPBeanDefinition> beanDefinitions) throws Exception {

        for (GPBeanDefinition beanDefinition : beanDefinitions) {
            if (super.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())) {
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + " bean definition is exists");
            }
            // 容器初始化完毕
            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
        }
    }
    // 装饰模式：
    //1.保留原来的oop关系
    //2.需要对它进行扩展、增强

    @Override
    public Object getBean(String beanName) throws IllegalAccessException {

        GPBeanDefinition beanDefinition = super.beanDefinitionMap.get(beanName);

        // 生成通知事件
        GPBeanPostProcessor beanPostProcessor = new GPBeanPostProcessor();
        Object instance = instantiateBean(beanDefinition);
        if (null == instance) {
            return null;
        }
        // 实例化前调用一次
        beanPostProcessor.postProcessBeforeInitialization(instance,beanName);
        this.factoryBeanInstanceCache.put(beanName, new GPBeanWrapper(instance));

        // 实例化后调用一次
        beanPostProcessor.postProcessAfterInitialization(instance, beanName);

        populateBean(beanName,instance);
        return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();
    }

    private void populateBean(String beanName, Object instance) throws IllegalAccessException {

        Class<?> clazz = instance.getClass();
        if (clazz.isAnnotationPresent(GPController.class)||
                clazz.isAnnotationPresent(GPService.class)) {
            return;
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(GPAutowired.class)) {
                continue;
            }
            GPAutowired autowired = field.getAnnotation(GPAutowired.class);
            String autoWiredBeanName = autowired.value().trim();
           if ("".equals(autoWiredBeanName)) {
               autoWiredBeanName = field.getType().getName();
           }
           field.setAccessible(true);
           field.set(instance,this.factoryBeanInstanceCache.get(autoWiredBeanName).getWrappedInstance());
        }
    }

    // 传一个beanDefinition，返回一个bean实例
    private Object instantiateBean(GPBeanDefinition beanDefinition) {

        Object instance = null;
        String className = beanDefinition.getBeanClassName();

        // 判断该类是否有实例
        if (this.factoryBeanInstanceCache.containsKey(className)) {
             instance = this.factoryBeanInstanceCache.get(className);
        }else {
            try {
                Class<?> clazz = Class.forName(className);
                 instance = clazz.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            this.factoryBeanObjectCache.put(beanDefinition.getFactoryBeanName(), instance);
            return instance;
        }

        return null;
    }

    @Override
    public Object getBean(Class<?> beanClass) throws Exception {
        return null;
    }
    public String[] getBeanDefinitionNames(){

        return this.beanDefinitionMap.keySet().toArray(new String [this.beanDefinitionMap.size()]);
    }

    public int getBeanDefinitionCount() {
        return this.beanDefinitionMap.size();
    }
    public Properties getConfig(){
        return this.reader.getConfig();
    }

}
