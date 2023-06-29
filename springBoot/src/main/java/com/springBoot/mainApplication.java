package com.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

/**
 * Description： 主程序
 *
 * @author: 段世超
 * @create: Created in 2023/6/27 9:13
 */
@SpringBootApplication
public class mainApplication {

    public static void main(String[] args) {

        // java 10:局部变量类型的自动推断
        var ioc = SpringApplication.run(mainApplication.class, args);

        // 1.获取容器中所有组建的名字
        String[] names = ioc.getBeanDefinitionNames();
        //2、挨个遍历：
        // dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
        // SpringBoot把以前配置的核心组件现在都给我们自动配置好了。
        for (String name : names) {
            System.out.println(name);

        }
    }
}
