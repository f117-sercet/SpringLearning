package com.spring.writable.annotation;

import jdk.nashorn.internal.objects.annotations.Constructor;

import java.lang.annotation.*;

/**
 * Description： TODO
 * 业务逻辑注入
 * @author: 段世超
 * @aate: Created in 2024/1/15 9:25
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPService {

    String value() default "";
    String version() default "1.1.0";
}
