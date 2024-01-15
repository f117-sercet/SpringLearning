package com.spring.writable.annotation;

import java.lang.annotation.*;

/**
 * Description： 页面交互
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 17:00
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPController {
    String value() default "";
}
