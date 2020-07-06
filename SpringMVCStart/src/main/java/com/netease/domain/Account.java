package com.netease.domain;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {
    private String name;
    private Float money;

    private List<User> users;
    private Map<String, User> mapUsers;

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", users=" + users +
                ", mapUsers=" + mapUsers +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, User> getMapUsers() {
        return mapUsers;
    }

    public void setMapUsers(Map<String, User> mapUsers) {
        this.mapUsers = mapUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
