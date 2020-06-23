package com.netease.dao;

import com.netease.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();
    List<Account> findByUid(Integer uid);
}
