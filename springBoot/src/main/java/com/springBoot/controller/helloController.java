package com.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/6/27 9:23
 */
@RestController
public class helloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello,SpringBoot 3 !";
    }
}
