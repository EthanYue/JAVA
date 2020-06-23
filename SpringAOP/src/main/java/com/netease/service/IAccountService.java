package com.netease.service;

import com.netease.domain.Account;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    Account findAccountById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);

    void transfer(String sourceName, String targetName, Float money);
}
