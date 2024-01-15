package com.spring.writable.annotation;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 16:57
 */

import java.lang.annotation.*;

/**
 * 自动注入
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPAutowired {
String value() default "";

}
