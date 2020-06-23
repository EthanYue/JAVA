package com.netease.servlet.util;

public class printUtils {

    public static String prints(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }

    public static void print(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println(prints("=", 50));
    }
}
