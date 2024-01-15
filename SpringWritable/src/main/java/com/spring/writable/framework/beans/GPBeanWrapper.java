package com.spring.writable.framework.beans;

import org.checkerframework.checker.units.qual.C;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 17:16
 */
public class GPBeanWrapper {
    private Object wrappedInstance;
    private Class<?> wrappedClass;

    public GPBeanWrapper(Object wrappedInstance){
        this.wrappedInstance = wrappedInstance;
    }
    public Object getWrappedInstance(){
        return this.wrappedInstance;
    }
    //返回代理以后的class
    // 可能会是这个$Proxy$
    public Class<?> getWrappedClass(){
        return this.wrappedInstance.getClass();
    }
}
