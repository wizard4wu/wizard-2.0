package com.dev.wizard.redis.cache;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 1. add the prefix in the module;
 * 2. inject the redis object
 */
public @interface AutoCache {

    String prefix() default "";
}
