package com.yd.yx.common.log.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName
 * @Description:
 * @Author:
 * @Date:
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceLogs {
    /**
     * 描述
     */
    String description() default "";
}
