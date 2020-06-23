package com.netease.day02.demo10;

import java.util.DoubleSummaryStatistics;

public class Main {
    public static void main(String[] args) {
        MyClass<String> myclass = new MyClass<>();
        myclass.setName("yuefeiyu");
        String name = myclass.getName();


        MyClass<Integer> myclass1 = new MyClass<>();
        myclass1.setName(1);
        Integer s = myclass1.getName();

        myclass1.method(10);
        myclass1.method("yuefeiyu");
    }
}


class MyClass<E> {
    public E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public <E> void method(E arg) {
        System.out.println(arg);
    }
}
