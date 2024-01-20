package com.spring.writable.webmvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义模板解析器
 *
 * @author: 段世超
 * @aate: Created in 2024/1/20 19:31
 */
public class GPView {

    public static final String DEFAULT_CONTENT_TYPE = "text/html;charset=UTF-8";
    private File viewFile;

    public GPView(File viewFile) {
        this.viewFile = viewFile;
    }
    public String getContentType() {
        return DEFAULT_CONTENT_TYPE;
    }
    public void render(Map<String,?>model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        StringBuffer sb = new StringBuffer();
        RandomAccessFile ra = new RandomAccessFile(this.viewFile, "r");

        try {
            String line =null;
            while (null != (line = ra.readLine())) {
                 line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                Pattern pattern = Pattern.compile("￥\\{^\\}]+\\}", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String paramName = matcher.group();
                    paramName= paramName.replaceAll("￥\\{^\\}]+\\}","");
                    Object paramNameValue = model.get(paramName);
                    if (null == paramName) {
                        continue;
                    }
                    // 把￥{}取出来
                    line = matcher.replaceFirst(makeStringForRegExp(paramNameValue.toString()));
                    matcher=pattern.matcher(line);
                }
                sb.append(line);
            }

        }catch (Exception e) {
             e.printStackTrace();
        }finally {
          ra.close();
        }
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(sb.toString());
    }

    // 处理特殊字符串
    public static String makeStringForRegExp(String str){

        return str.replace("\\","\\\\")
                .replace("*","\\*")
                .replace("+","\\+")
                .replace("|","\\|")
                .replace("{","\\}")
                .replace("(","\\(").replace(")","\\)")
                .replace("^","\\^").replace("$","\\$")
                .replace("[","\\[").replace("]","\\]")
                .replace("?","\\?").replace(",","\\,")
                .replace(".","\\.").replace("&","\\&");

    }

}
