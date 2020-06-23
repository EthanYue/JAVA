package com.netease.day02.demo05;

public class Keyboard implements USBInterface {
    @Override
    public void turnOn() {
        System.out.println("turn on keyboard;");
    }

    @Override
    public void turnOff() {
        System.out.println("turn off keyboard;");
    }

    public void type() {
        System.out.println("I can type");
    }
}
