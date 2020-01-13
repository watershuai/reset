package com.water.reset.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.METHOD,ElementType.TYPE})
public @interface pageView {
    /**
     * 描述
     */
    String description()  default "";
}
