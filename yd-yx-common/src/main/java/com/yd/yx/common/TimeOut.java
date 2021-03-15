package com.yd.yx.common;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName
 * @Description:
 * @Author:
 * @Date:
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TimeOut {
    long value();

    TimeUnit timeUnit()default TimeUnit.MILLISECONDS;

    String fallBack()default "";

}
