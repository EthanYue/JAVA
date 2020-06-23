package com.netease.day02.demo04;

public class DemoInterface {
    public static void main(String[] args) {
        MyInterfaceAbstractImpl impl = new MyInterfaceAbstractImpl();
        impl.methodAbs1();
        impl.methodAbs2();
        impl.methodAbs3();
        impl.methodAbs4();
        impl.methodDefault();
//        impl.methodStatic(); wrong
        MyInterfaceAbstract.methodStatic();
//        impl.methodCommon(); wrong
//        MyInterfaceAbstract.methodStaticCommon(); wrong
        System.out.println(MyInterfaceAbstract.NUM);
    }
}
