package com.netease.service.impl;

import com.netease.dao.IAccountDao;
import com.netease.dao.impl.AccountDaoImpl;
import com.netease.service.IAccountService;
import org.springframework.scheduling.annotation.AnnotationAsyncExecutionInterceptor;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
//        accountDao.saveAccount();
        System.out.println("saveAccount method in AccountService: " + name + age + birthday);
    }
}
