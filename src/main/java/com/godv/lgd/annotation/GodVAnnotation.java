package com.godv.lgd.annotation;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface GodVAnnotation {


    @AliasFor(
            annotation = Configuration.class
    )
    boolean proxyBeanMethods() default true;
}
