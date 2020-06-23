package com.netease.day02.demo05;

public class Mouse implements USBInterface {
    @Override
    public void turnOn() {
        System.out.println("turn on mouse;");
    }

    @Override
    public void turnOff() {
        System.out.println("turn off mouse;");
    }

    public void click() {
        System.out.println("I can click");
    }
}
