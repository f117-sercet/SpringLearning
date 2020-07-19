package com.demo.Controller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
@GetMapping("/hellow")
    public  String hellow(){
    return "ctmad996";

}
}
