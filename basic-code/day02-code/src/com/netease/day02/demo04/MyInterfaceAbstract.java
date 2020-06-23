package com.netease.day02.demo04;

/*
all Interface can define abstract method, the modifier must be public and abstract, can omit;
all Interface can define const, the modifier must be public static final and be assignment, can omit;
if the abstract method name in more than one Interface, this method just be override once;
if the default method name in more than one Interface and the body are different, this method must be override;
a Class only can extends one Class, but a Interface can extends more than one Interface;
a Class only can extends one Class, but can implements more than one Interface;
Extends prior to the Interface

java 8:
default method can solve problems of upgrading Interface;
public default ret_type method_name(args) { body }, can be directly called or override;

public static ret_type method_name(args) {body}, not must be implemented, can not be called

java9:
solve the problem that multi methods have duplicate codes, can not be called by the class;
normal private method: private ret_type method_name(args) {body}
static private method: private static ret_type method_name(args) {body}
*/


public interface MyInterfaceAbstract {
    public static final int NUM = 10;  // const

    public abstract void methodAbs1 ();
    abstract void methodAbs2();
    public void methodAbs3();
    void methodAbs4();
    public default void methodDefault() {};
    public static void methodStatic() {};

//    public default void methodDefault1() {
//        methodCommon();
//    }
//
//    public default void methodDefault2() {
//        methodCommon();
//    }

//    private void methodCommon() {
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
//    }

//    public static void methodStatic1() {
//        methodStaticCommon();
//    }
//
//    public static void methodStatic2() {
//        methodStaticCommon();
//    }
//
//    private static void methodStaticCommon() {
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
//    }
}
