package com.spring.writable.webmvc.servlet;

/**
 * 主要完成模板名称和模板解析引擎的匹配，
 * 通过在servlet中调用resolveViewName方法来获得模板引擎所对应的View。
 * 在这个Mini版本简化了实现，只实现了一套默认的模板引擎
 * @author: 段世超
 * @aate: Created in 2024/1/20 18:16
 */

import com.sun.tools.corba.se.idl.StringGen;

import java.io.File;
import java.util.Locale;

/**
 * 将一个静态文件转换为动态文件
 * 根据用户传递不同的参数，产生不同的结果
 * 最终输出字符串，交给Response处理
 */
public class GPViewResolver {

    private final String DEFAULT_TEMPLATE_SUFFIX =".html";
    private File templateRootDir;
    private String viewName;

    public GPViewResolver(String templateRoot){
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        this.templateRootDir = new File(templateRootPath);
    }

    public GPView resolveViewName(String viewName, Locale locale) throws Exception{
        this.viewName = viewName;
        if (null == viewName || "".equals(viewName.trim())) {
             viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFIX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFFIX);
            File templateFile = new File((templateRootDir.getPath() + "/" + viewName).replaceAll("/+", "/"));
            return  new GPView(templateFile);
        }
    }
    public String getViewName(){
        return viewName;
    }


}
