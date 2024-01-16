package com.spring.writable.framework.context;

import com.spring.writable.framework.context.support.GPDefaultListableBeanFactory;
import com.spring.writable.framework.core.GPBeanFactory;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/16 9:40
 */
public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory {

    private String[] configLocations;
    private GP
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
        super.refresh();
    }
}
