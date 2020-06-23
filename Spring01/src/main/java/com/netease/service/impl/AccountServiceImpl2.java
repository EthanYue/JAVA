package com.netease.service.impl;

import com.netease.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
//        accountDao.saveAccount();
        System.out.println("saveAccount method in AccountService: " + name + age + birthday);
    }
}
