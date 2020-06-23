package com.netease.test;

import com.netease.domain.Account;
import com.netease.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)  // spring combined with junit, rewrite main method to create spring core container;
@ContextConfiguration(classes=SpringConfiguration.class)  // load configuration file
//@ContextConfiguration(locations="classpath:bean.xml")  // load configuration file
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testCRUD() {

        accountService.transfer("allenyue", "yuefeiyu", 1000f);

        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
