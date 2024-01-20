package com.spring.writable.webmvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 主要完成请求传递到服务端的参数列表与Method实参列表的对应关系，完成参数值的类型转换工作，
 * 核心方法是handle(),在handle方法用反射来调用被适配的目标方法，并将转换包装好的参数列表传递过去。
 * @author: 段世超
 * @aate: Created in 2024/1/20 18:08
 */
public class GPHandlerAdapter {

    public boolean supports(Object handler){
        return (handler instanceof  GPHandlerMapping);
    }
    public GPModelAndView handle(HttpServletRequest req, HttpServletResponse resp,Object handler) throws Exception{

       GPHandlerMapping handlerMapping =(GPHandlerMapping)handler;

       // 保存形参列表
        HashMap<String, Integer> paramMapping = new HashMap<>();
        return null;
    }
}
