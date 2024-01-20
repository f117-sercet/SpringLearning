package com.spring.writable.webmvc.servlet;

import java.util.Map;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/20 18:13
 */
public class GPModelAndView {

    private String viewName; //页面模板参数的名称
    private Map<String, ?> model; //往页面传递的参数

    public GPModelAndView(String viewName){
        this(viewName,null);


    }

    public GPModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }

    public void setModel(Map<String, ?> model) {
        this.model = model;
    }
}
