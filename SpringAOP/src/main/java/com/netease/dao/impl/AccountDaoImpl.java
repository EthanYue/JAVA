package com.netease.dao.impl;

import com.netease.dao.IAccountDao;
import com.netease.domain.Account;
import com.netease.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Resource(name="runner")
    private QueryRunner runner;

    @Autowired
    private ConnectionUtils connectionUtils;

    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer id) {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "insert into account (uid, money) values (?, ?)", account.getUid(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "update account set uid=?, money=? where id=?", account.getUid(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer id) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "delete from account where id=?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String name) {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "select * from account where name=?", new BeanHandler<Account>(Account.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
