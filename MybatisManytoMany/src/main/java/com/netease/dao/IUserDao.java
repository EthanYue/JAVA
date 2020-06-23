package com.netease.dao;

import com.netease.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    User findById(Integer id);

}
