package com.netease.day02.demo05;

public class Main {
    public static void main(String[] args) {
        LapTop lapTop = new LapTop();
        lapTop.powerOn();
        lapTop.work(new Mouse());
        lapTop.work(new Keyboard());
        lapTop.powerOff();
    }
}
