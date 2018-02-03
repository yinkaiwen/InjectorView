package com.example.kevin.injectorview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface Injector {
    public static final String INJECTOR = "Injector";
    int value();
}
