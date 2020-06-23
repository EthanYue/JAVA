package com.netease.service.impl;

import com.netease.dao.IAccountDao;
import com.netease.dao.impl.AccountDaoImpl;
import com.netease.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.AnnotationAsyncExecutionInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;


// @Component("accountService") create object and storage to the spring container, default prop: {accountServiceImpl: Object}
/*
* follow three annotation is same as @Component
* @Controller
* @Service
* @Repository
*/
@Service("accountService")
//@Scope("prototype") // scope default is singleton
public class AccountServiceImpl implements IAccountService {

    /*
    @Autowired // injection by Type automatically
    @Qualifier("accountDao")  // injection by name and can't used alone, must be used with @Autowired
    */
    @Resource(name="accountDao")
    private IAccountDao accountDao;

    @PostConstruct
    public void init() {
        System.out.println("init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy method");
    }

    public void saveAccount() {
        System.out.println("saveAccount method in AccountService");
        accountDao.saveAccount();
    }
}
