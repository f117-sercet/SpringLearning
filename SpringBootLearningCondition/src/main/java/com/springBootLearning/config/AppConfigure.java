package com.springBootLearning.config;

import com.alibaba.druid.FastsqlException;
import com.springBootLearning.bean.Cat;
import com.springBootLearning.bean.Dog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/7 16:55
 */
@Configuration
public class AppConfigure {

    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01(){
        return new Cat();
    }


    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01(){
        return new Dog();
    }
}
