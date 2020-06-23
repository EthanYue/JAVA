package com.netease.test;

import com.netease.dao.IUserDao;
import com.netease.dao.impl.UserDaoImpl;
import com.netease.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MybatisAnnotationTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("DBConfig.xml");  // mybatis use class loader or servletContext.getRealPath() to load config file;


        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();  // mybatis use builder mode to build a factory;
        SqlSessionFactory factory = builder.build(in);
//
//        UserDaoImpl userDao = new UserDaoImpl(factory);  // implement IUserDao interface
//        List<User> users = userDao.findAll();

        SqlSession sqlSession = factory.openSession();  // mybatis use factory mode to product a SqlSession Object;
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

        in.close();

    }
}
