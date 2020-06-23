package com.netease.day02.demo08;

import com.netease.util.printUtils;

import java.util.ArrayList;
import java.util.Random;

public class Bootstrap {
    public static void main(String[] args) {
        RedFrame redFrame = new RedFrame();
        redFrame.setOwerName("ethan");
        redFrame.setTotalCount(3);
        redFrame.setTotalMoney(10);
        OpenMode avgMode = new OpenMode() {
            @Override
            public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
                ArrayList<Integer> redArr = new ArrayList<>();
                int avg = totalMoney / totalCount;
                for (int i = 0; i < totalCount-1; i++) {
                    redArr.add(avg);
                }
                redArr.add(avg + totalMoney % totalCount);
                return redArr;
            }
        };

        /*OpenMode randomMode = new OpenMode() {
            @Override
            public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
                ArrayList<Integer> redArr = new ArrayList<>();
                int restMoney = totalMoney;
                int resCount = totalCount;
                for (int i = totalCount; i > 1;) {
                    int avg = restMoney / i;
                    int rd = (int)(Math.random() * restMoney);
                    if (rd > avg * 2 || rd < 1) continue;
                    redArr.add(rd);
                    restMoney -= rd;
                    i--;
                }
                redArr.add(restMoney);
                return redArr;
            }
        };*/

        OpenMode randomMode = new OpenMode() {
            @Override
            public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
                ArrayList<Integer> redArr = new ArrayList<>();
                int restMoney = totalMoney;
                int resCount = totalCount;
                Random random = new Random();
                for (int i = totalCount; i > 1; i--) {
                    int rd = random.nextInt(restMoney / resCount * 2) + 1;
                    redArr.add(rd);
                    restMoney -= rd;
                }
                redArr.add(restMoney);
                return redArr;
            }
        };
        redFrame.setOpenMode(avgMode);
        ArrayList<Integer> avg = redFrame.getOpenMode().divide(redFrame.totalMoney, redFrame.totalCount);
        for (int i = 0; i < avg.size(); i++) {
            System.out.print(avg.get(i) + " ");
        }
        System.out.println();
        printUtils.print("=", 50);
        redFrame.setOpenMode(randomMode);
        ArrayList<Integer> rd = redFrame.getOpenMode().divide(redFrame.totalMoney, redFrame.totalCount);
        for (int i = 0; i < rd.size(); i++) {
            System.out.print(rd.get(i) + " ");
        }
    }
}
