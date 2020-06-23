package com.dao.impl;

import com.dao.IAccountDao;
import com.doamin.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class IAccountImpl extends JdbcDaoSupport implements IAccountDao {

    public Account findAccountByName(String name) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "yuefeiyu");
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set money = ? where name = ?", account.getMoney(), account.getName());
    }
}
