package com.spring.writable.framework.beans.config;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/20 16:36
 */
public class GPBeanPostProcessor {

    // 为在Bean的初始化之前提供回调接口
    public Object postProcessBeforeInitialization(Object bean,String beanName){
        return bean;
    }
    // 在bean的初始化之后提供回调接口
    public Object postProcessAfterInitialization(Object bean,String beanName){
        return bean;
    }
}
