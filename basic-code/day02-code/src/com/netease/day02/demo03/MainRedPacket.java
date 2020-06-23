package com.netease.day02.demo03;

import com.netease.util.printUtils;

import java.util.ArrayList;

public class MainRedPacket {
    public static void main(String[] args) {
        Manager manager = new Manager("yuefeiyu", 100);
        Member one = new Member("one", 0);
        Member two = new Member("two", 0);
        Member three = new Member("three", 0);

        manager.show();
        one.show();
        two.show();
        three.show();
        printUtils.print("=", 50);

        ArrayList<Integer> redList = manager.send(20, 3);
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);

        manager.show();
        one.show();
        two.show();
        three.show();
    }

}
