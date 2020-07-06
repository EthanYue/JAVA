package com.netease.test;

import com.netease.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountServiceImpl accountService = ac.getBean("accountService", AccountServiceImpl.class);
        accountService.findAll();
    }
}
