package com.spring.writable.webmvc.servlet;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/20 17:37
 */
@Slf4j
public class GPHandlerMapping {
    private Object controller; // 目标方法所在的controller
    private Method method; // 目标方法

    private Pattern pattern; //url 对应的封装

    public GPHandlerMapping(Pattern pattern, Object controller, Method method){

        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
    }
    public Object getController(){
        return controller;
    }
    public void setController(Object controller){
        this.controller = controller;
    }
    public Method getMethod(){
        return  method;
    }
    public void setMethod(Method method){
        this.method = method;
    }
    public Pattern getPattern(){
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
