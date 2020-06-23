package com.netease.service.impl;

import com.netease.dao.IAccountDao;
import com.netease.domain.Account;
import com.netease.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name="accountDao")
    private IAccountDao accountDao;

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
