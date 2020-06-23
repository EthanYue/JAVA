package com.netease.day02.demo12;

public class MultiArgs {
    public static void main(String[] args) {
        int i = add();
        System.out.println(i);
        int i1 = add(10, 20, 30);
        System.out.println(i1);
    }

    public static int add(int...arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(arr);
        System.out.println(arr.length);
        return sum;
    }

    //public static void method(int...arr, String...str) {}  wrong
    //public static void method(String...str, double d, int i) {}  wrong
    public static void method(double d, int i, String...str) {}
}
