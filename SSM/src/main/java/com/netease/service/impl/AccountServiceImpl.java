package com.netease.service.impl;
import com.netease.dao.IAccountDao;
import com.netease.domain.Account;
import com.netease.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("service find all accounts;");
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    public void saveAccount(Account account) {
        System.out.println("service save account;");
        accountDao.saveAccount(account);
    }
}
