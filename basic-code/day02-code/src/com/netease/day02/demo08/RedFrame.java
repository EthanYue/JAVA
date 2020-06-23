package com.netease.day02.demo08;

public class RedFrame {
    String owerName;
    OpenMode openMode;
    int totalMoney;
    int totalCount;

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney * 100;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getOwerName() {
        return owerName;
    }

    public void setOwerName(String owerName) {
        this.owerName = owerName;
    }

    public OpenMode getOpenMode() {
        return openMode;
    }

    public void setOpenMode(OpenMode openMode) {
        this.openMode = openMode;
    }
}
