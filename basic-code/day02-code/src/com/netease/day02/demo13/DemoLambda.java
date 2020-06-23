package com.netease.day02.demo13;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.RandomAccess;

public class DemoLambda {
    public static void main(String[] args) {
        anonymousMethod();
        lambdaMethod();
    }

    public static void anonymousMethod() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }

    public static void lambdaMethod() {
        new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
            }
        ).start();
    }
}
