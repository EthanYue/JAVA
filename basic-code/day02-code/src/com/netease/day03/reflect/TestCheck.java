package com.netease.day03.reflect;

import javafx.animation.ScaleTransition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        BufferedWriter bw = new BufferedWriter(new FileWriter("exception.txt"));
        int eCnt = 0;
        Method[] methods = calculator.getClass().getMethods();
        for (Method method : methods) {
            if (!method.isAnnotationPresent(Check.class)) continue;
            try {
                method.invoke(calculator);
            } catch (Exception e) {
                eCnt++;
                bw.write(method.getName() + "throws a exception");
                bw.newLine();
                bw.write("exception name: " + e.getCause().getClass().getSimpleName());
                bw.newLine();
                bw.write("exception cause: " + e.getCause().getMessage());
                bw.newLine();
            }
        }
        bw.write("exception count: " + eCnt);
        bw.flush();
        bw.close();
    }
}
