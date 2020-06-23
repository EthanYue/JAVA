package com.netease.dao.impl;

import com.netease.dao.IAccountDao;
import org.springframework.stereotype.Repository;


@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("saveAccount method in AccountDao;");
    }
}
