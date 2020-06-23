package com.netease.day02.demo03;

import java.util.ArrayList;

public class Manager extends User{
    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney, int count) {
        ArrayList<Integer> redList = new ArrayList<>();
        int leftMoney = super.getMoney();

        if (totalMoney > leftMoney) {
            System.out.println("no enough money");
            return redList;
        }

        super.setMoney(leftMoney - totalMoney);

        int avg = totalMoney / count;
        int mod = totalMoney % count;

        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }
        redList.add(avg + mod);

        return redList;
    }
}
