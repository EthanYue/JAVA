package com.netease.dao.impl;

import com.netease.dao.IUserDao;
import com.netease.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession sqlSession = factory.openSession();
        List<User> users = sqlSession.selectList("com.netease.dao.IUserDao.findAll");
        sqlSession.commit();
        sqlSession.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.netease.dao.IUserDao.saveUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer id) {

    }

    public User findById(Integer id) {
        return null;
    }

    public List<User> findByName(String name) {
        return null;
    }

    public Integer findTotal() {
        return null;
    }
}
