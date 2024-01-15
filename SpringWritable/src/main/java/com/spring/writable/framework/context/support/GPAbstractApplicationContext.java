package com.spring.writable.framework.context.support;

/**
 * Description： Ioc容器顶层实现
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 17:21
 */
public abstract class GPAbstractApplicationContext {

    // 受保护,只提供给子类重写
    public void refresh() throws Exception{}
}
