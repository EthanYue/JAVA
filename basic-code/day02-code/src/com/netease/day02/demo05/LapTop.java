package com.netease.day02.demo05;

public class LapTop {
    public void powerOn() {
        System.out.println("power on laptop");
    }

    public void powerOff() {
        System.out.println("power off laptop");
    }

    public void work(USBInterface usb) {
        usb.turnOn();
        if (usb instanceof Mouse) ((Mouse) usb).click();
        if (usb instanceof Keyboard) ((Keyboard) usb).type();
        usb.turnOff();
    }
}
