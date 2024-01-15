package com.spring.writable.framework.core;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 17:04
 */
public interface GPBeanFactory {

    /**
     * 根据beanName从IOC容器中获得一个实例bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);

    public Object getBean(Class<?> beanClass) throws Exception;
}
