package com.spring.writable.annotation;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 9:22
 */

import java.lang.annotation.*;

/**
 * 请求URL
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestMapping {
    String value() default "";
}
