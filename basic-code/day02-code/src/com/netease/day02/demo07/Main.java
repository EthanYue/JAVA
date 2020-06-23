package com.netease.day02.demo07;
import com.netease.util.printUtils;

/*
if the class implemented Interface just use once, then it can be omitted, use anonymous inner class

ifName objName = new ifName() {
    override body;
}

 */

public class Main {
    public static void main(String[] args) {
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.method();

        printUtils.print("=", 50);

        MyInterface obj = new MyInterfaceImpl();
        obj.method();

        printUtils.print("=", 50);

        MyInterface obj1 = new MyInterface() {
            @Override
            public void method() {
                System.out.println("anonymous inner class");
            }
        };
        obj1.method();

    }
}
