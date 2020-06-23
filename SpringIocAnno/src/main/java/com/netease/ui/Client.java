package com.netease.ui;

import com.netease.dao.IAccountDao;
import com.netease.service.IAccountService;
import com.netease.service.impl.AccountServiceImpl;
import com.sun.org.apache.xml.internal.utils.res.XResourceBundle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("Application load configuration file finish");

        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.saveAccount();

        ac.close(); 

//        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
//        accountDao.saveAccount();
    }
}
