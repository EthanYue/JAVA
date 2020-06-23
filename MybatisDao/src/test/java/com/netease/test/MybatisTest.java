package com.netease.test;

import com.netease.dao.IUserDao;
import com.netease.dao.impl.UserDaoImpl;
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


public class MybatisTest {
    private InputStream cfg;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        cfg = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(cfg);
//        sqlSession = factory.openSession();
//        userDao = sqlSession.getMapper(IUserDao.class);
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void destroy() throws IOException {
        cfg.close();
    }

    @Test
    public void findAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void saveUser(){
        User user = new User(4, "ethanyue", "ethanyue");
        userDao.saveUser(user);
        findAll();
    }

    @Test
    public void updateUser(){
        User user = new User(3, "allenyue", "allenyue");
        userDao.updateUser(user);
        findAll();
    }

    @Test
    public void deleteUser(){
        userDao.deleteUser(3);
        findAll();
    }

    @Test
    public void findById(){
        User user = userDao.findById(2);
        System.out.println(user);
    }

    @Test
    public void findByName(){
        List<User> users = userDao.findByName("%yue%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findTotal() {
        Integer total = userDao.findTotal();
        System.out.println(total);
    }
}
