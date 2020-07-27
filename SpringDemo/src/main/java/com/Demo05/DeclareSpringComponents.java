package com.Demo05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

/**
 * 测试类
 * @author dsc
 */
public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx=new GenericXmlApplicationContext ();
        ctx.load("Demo05.xml");
        ctx.refresh();
        MessgaeRenderer messgaeRenderer=ctx.getBean("render",MessgaeRenderer.class);
        messgaeRenderer.render();
        ctx.close();
    }
}
