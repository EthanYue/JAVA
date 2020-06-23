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

public class SecondCacheTest {
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
        in.close();
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(46);
        System.out.println(user);
        sqlSession.close();

        SqlSession sqlSession1 = factory.openSession();
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(46);
        System.out.println(user1);
        sqlSession1.close();

    }
}
