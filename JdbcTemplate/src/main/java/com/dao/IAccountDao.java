package com.dao;

import com.doamin.Account;

public interface IAccountDao {
    Account findAccountByName(String name);

    void updateAccount(Account account);
}
