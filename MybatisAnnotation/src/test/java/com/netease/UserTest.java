package com.netease;

import com.netease.dao.IUserDao;
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
import java.util.Date;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit(true);
        in.close();
        sqlSession.close();
    }

    @Test
    public void CRUD(){
//        User user = new User();
//        user.setUsername("yuefeiyu");
//        user.setBirthday(new Date());
//        userDao.saveUser(user);
//
//        User updateUser = new User();
//        updateUser.setId(49);
//        updateUser.setUsername("ethanyue");
//        userDao.updateUser(updateUser);
//
//        userDao.delete(50);

        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
            System.out.println(u.getAccounts());
        }
    }
}
