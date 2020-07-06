package com.netease.dao;

import com.netease.domain.Member;
import com.netease.domain.Order;
import com.netease.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMemberDao {

    @Select("select * from member")
    public List<Member> findAll();

    @Select("select * from member where id = #{id}")
    public Member findById();
}
