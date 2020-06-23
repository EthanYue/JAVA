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
        /* get core container object
        ApplicationContext create object when load configuration file;
        BeanFactory create object when id is called;
         */



        // by ApplicationContext
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("Application load configuration file finish");
        // get Bean Object by id
        IAccountService accountService = (IAccountService) ac.getBean("accountService");

        System.out.println(accountService);
        accountService.saveAccount();

        System.out.println("--------------------------------------------------------");


        // by BeanFacory
       /* Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("BeanFacory load configuration file finish");
        IAccountService accountService1 = factory.getBean("accountService", IAccountService.class);
        System.out.println(accountService1);*/
    }
}
