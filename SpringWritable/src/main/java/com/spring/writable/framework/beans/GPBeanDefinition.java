package com.spring.writable.framework.beans;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 17:07
 */
// 用来存储配置文件相关信息
// 保存在内存中的配置
public class GPBeanDefinition {

    private String beanClassName; //原生bean的全类名
    private boolean lazyInit = false; //标记是否延时加载
    private String factoryBeanName; //保存beanName,在Ioc容器中存储的key
    public String getBeanClassName() {
        return beanClassName;
    }
    public void setBeanClassName(String beanClassName){
        this.beanClassName = beanClassName;

    }

    public boolean isLazyInit(){
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
    public String getFactoryBeanName(){

        return factoryBeanName;
    }
    public void setFactoryBeanName(String factoryBeanName){
        this.factoryBeanName =factoryBeanName;
    }
}
