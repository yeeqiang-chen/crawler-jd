package com.yiqiang.crawler.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/11 0011 15:22
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PropertyConfig {
    String value() default "";
    boolean required() default true;
}
