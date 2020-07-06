package com.netease.dao;

import com.netease.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "status", column = "status"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select="com.netease.dao.IRoleDao.findById"))
    })
    public User findByName(String username);

    @Select("select * from users")
    public List<User> findAll();
}
