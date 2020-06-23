package com.netease.test;

import com.netease.domain.Account;
import com.netease.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    @Test
    public void testCRUD() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

        Account account1 = accountService.findAccountById(45);
        System.out.println(account1);
    }
}
