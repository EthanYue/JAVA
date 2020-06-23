package com.netease.dao;

import com.netease.domain.Account;
import com.netease.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking=true)  // enable second cache
public interface IUserDao {

    @Select("select * from user;")
    @Results(id="userMap" ,value={
            @Result(id=true, column="id", property="id"),
            @Result(column="username", property="username"),
            @Result(column="address", property="address"),
            @Result(column="id", property="accounts", many=@Many(select="com.netease.dao.IAccountDao.findByUid", fetchType= FetchType.LAZY))
    })
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    @ResultMap("userMap")
    void saveUser(User user);

    @Update("update user set username=#{username} where id=#{id};")
    @ResultMap("userMap")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    @ResultMap("userMap")
    void delete(Integer id);
}
