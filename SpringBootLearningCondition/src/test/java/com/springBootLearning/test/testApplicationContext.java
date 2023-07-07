package com.springBootLearning.test;

import com.alibaba.druid.FastsqlException;
import com.springBootLearning.bean.Cat;
import com.springBootLearning.bean.Dog;
import com.springBootLearning.mainApplication;
import jakarta.annotation.Resource;
import org.apache.naming.factory.BeanFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.swing.*;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/7 17:12
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class testApplicationContext {

    @Resource
    private ApplicationContext applicationContext;
    @Resource
    private ApplicationContextAware applicationContextAware;

    @Test
    public void test01() throws Exception {


        applicationContextAware.setApplicationContext(applicationContext);

        Dog dog = (Dog) applicationContext.getBean("dog");
        System.out.println(dog);
    }
}
