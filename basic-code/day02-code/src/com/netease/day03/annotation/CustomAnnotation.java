package com.netease.day03.annotation;


import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * public interface CustomAnnotation extends java.lang.annotation.Annotation{}
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RUNTIME)
@Documented
@Inherited
public @interface CustomAnnotation {
    public abstract String name();
    public abstract int age();
    public abstract String location() default "hangzhou";
}
