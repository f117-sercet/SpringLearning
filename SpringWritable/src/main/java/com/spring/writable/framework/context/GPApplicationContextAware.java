package com.spring.writable.framework.context;

/**
 * Description： 将自动调用SetApplicationContext(),从而将IOC容器注入目标类中。
 *
 * @author: 段世超
 * @aate: Created in 2024/1/16 15:22
 */
public interface GPApplicationContextAware {

    void setApplicationContext(GPApplicationContext applicationContext);
}
