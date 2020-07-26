package com.Demo05;

import org.springframework.stereotype.Component;
/**
 * 利用注解
 * @author 小沙
 */

@Component("provider")
public class HelloWorldMessageProvider  implements MessageProvider {
    @Override
    public String getMessage() {
        return "hello,world";
    }
}
