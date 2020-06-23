package com.netease.test;

import com.netease.dao.IAccountDao;
import com.netease.dao.IUserDao;
import com.netease.domain.Account;
import com.netease.domain.AccountUser;
import com.netease.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AccountTest {
    private InputStream cfg;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        cfg = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(cfg);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        cfg.close();
        sqlSession.close();
    }

    @Test
    public void findAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void findAllAccountUser(){
        List<AccountUser> aus = accountDao.findAllAccount();
        for (AccountUser au : aus) {
            System.out.println(au);
        }
    }
}
