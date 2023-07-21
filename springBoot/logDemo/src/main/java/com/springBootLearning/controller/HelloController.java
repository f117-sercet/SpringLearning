package com.springBootLearning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/21 15:42
 */
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/h")
    public String hello(){
        log.info("Hello");
        log.trace("trace");
        log.debug("debug");
        log.warn("warn");
        return "Hello";

    }
}
