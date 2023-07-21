package com.springBootLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/21 15:32
 */

@SpringBootApplication
public class mainApplication {

    public static void main(String[] args) {


        var ioc = SpringApplication.run(mainApplication.class, args);;
    }
}
