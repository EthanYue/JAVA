package com.netease.dao;

import com.netease.domain.Member;
import com.netease.domain.Order;
import com.netease.domain.Product;
import com.netease.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one=@One(select="com.netease.dao.IProductDao.findById")),
    })
    public List<Order> findAll();


    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one=@One(select="com.netease.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one=@One(select="com.netease.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many=@Many(select="com.netease.dao.ITravellerDao.findByOrderId"))
    })
    public Order findById(Integer id);
}

