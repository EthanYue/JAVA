package com.netease.dao;

import com.netease.domain.Account;
import com.netease.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    List<AccountUser> findAllAccount();
}
