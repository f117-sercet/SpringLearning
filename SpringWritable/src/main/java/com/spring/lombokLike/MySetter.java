package com.spring.lombokLike;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 11:36
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface MySetter {
}
