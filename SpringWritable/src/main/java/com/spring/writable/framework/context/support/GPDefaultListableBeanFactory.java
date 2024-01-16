package com.spring.writable.framework.context.support;

import com.spring.writable.framework.beans.GPBeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description： 存储注册信息
 *
 * @author: 段世超
 * @aate: Created in 2024/1/16 9:37
 */
public class GPDefaultListableBeanFactory extends GPAbstractApplicationContext {

    protected  final Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,GPBeanDefinition>();
}
