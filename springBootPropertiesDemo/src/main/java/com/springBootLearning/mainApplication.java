package com.springBootLearning;

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
    }
}
