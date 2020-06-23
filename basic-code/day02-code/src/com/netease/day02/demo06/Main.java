package com.netease.day02.demo06;
/*
inner class
*/
import com.netease.util.printUtils;

public class Main {
    public static void main(String[] args) {
        Body body = new Body();
        body.methodBody();

        printUtils.print("=", 50);

        Body.Heart bh = new Body().new Heart();
        bh.beat();

    }
}
