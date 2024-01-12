package com.springBootLearning;

import com.alibaba.druid.FastsqlException;
import com.springBootLearning.bean.Cat;
import com.springBootLearning.bean.Dog;
import com.springBootLearning.bean.Pig;
import com.springBootLearning.bean.Sheep;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

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

        Pig pig = ioc.getBean(Pig.class);
        System.out.println(pig);
        Sheep sheep = ioc.getBean(Sheep.class);
        System.out.println(sheep);
    }
    }
