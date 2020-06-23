package com.netease.dao;

import com.netease.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findById(Integer id);

    List<User> findByName(String name);

    Integer findTotal();
}
