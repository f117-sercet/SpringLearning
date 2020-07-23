package com.Demo02;


/**
 * Spring上下文拉取
 * 当容器准备将依赖项传递给组件时，会依次调用每个组件的performLookup()方法，然后可以使用Container接口查找所需的依赖项
 */
public interface ManagedComponent {
    void performLookup(Container container);
}
