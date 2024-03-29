package com.springBootLearning;

import com.alibaba.druid.FastsqlException;
import org.springframework.beans.FatalBeanException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/6/29 15:34
 */
@SpringBootApplication
public class mainApplication {
    public static void main(String[] args) {


        var ioc = SpringApplication.run(mainApplication.class, args);
/*
        String[] names = ioc.getBeanDefinitionNames(FatalBeanException.class);
        for (String name : names) {
            System.out.println(name);*/

        String[] forType = ioc.getBeanNamesForType(FastsqlException.class);

        for (String s : forType) {
            System.out.println(s);
        }
    }

}
