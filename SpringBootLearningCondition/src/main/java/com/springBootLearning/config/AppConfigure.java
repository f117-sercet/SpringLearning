package com.springBootLearning.config;

import com.alibaba.druid.FastsqlException;
import com.springBootLearning.bean.Cat;
import com.springBootLearning.bean.Dog;
import com.springBootLearning.bean.Pig;
import com.springBootLearning.bean.Sheep;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/7 16:55
 */
@Configuration
@EnableConfigurationProperties(Sheep.class)
// 1.开启组件的属性绑定 2.默认会把这个组件自己放到容器中 3.springBoot默认只扫描自己主程序所在的包
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
