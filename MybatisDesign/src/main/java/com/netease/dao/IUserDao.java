package com.netease.dao;
import com.netease.domain.User;
import com.netease.mybatis.annotation.Select;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
