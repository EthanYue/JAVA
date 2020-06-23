package com.netease.service;

import com.netease.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    Account findAccountById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);
}
