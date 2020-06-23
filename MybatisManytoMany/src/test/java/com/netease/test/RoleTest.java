package com.netease.test;

import com.netease.dao.IRoleDao;
import com.netease.dao.IUserDao;
import com.netease.domain.Role;
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


public class RoleTest {
    private InputStream cfg;
    private SqlSession sqlSession;
    private IRoleDao roleDao;

    @Before
    public void init() throws IOException {
        cfg = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(cfg);
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(IRoleDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        cfg.close();
        sqlSession.close();
    }

    @Test
    public void findAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }

    }
}
