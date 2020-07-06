package com.netease.dao;

import com.netease.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId = #{id})")
    public List<Role> findById(Integer id);
}
