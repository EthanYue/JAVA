package com.netease.day03.annotation;

/**
 * annotations predefined in JDK;
 * @Override: if this method extend superClass or interface
 * @Deprecated: this annotation is out of date;
 * @SuppressWarnings: suppress warnings
 */

@SuppressWarnings("all")
public class Annotation {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void method1() {
        System.out.println("out of date method");
    }

    public void method2() {
        System.out.println("new method");
    }

    @CustomAnnotation(name="yuefeiyu", age=18)
    public void show() {
        method1();
        method2();
    }
}
