package com.dmall.hisen.service.annotation;

import java.lang.annotation.*;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/9/8 17:19
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FruitAnnotation {
    String value() default "";
}
