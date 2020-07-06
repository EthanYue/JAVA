package com.netease.dao;

import com.netease.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    @Select("select * from product")
    public List<Product> findAll();

    @Select("select * from product where id = #{id}")
    public Product findById(Integer id);

    @Insert("insert into product (productNum, productName, cityName , DepartureTime, productPrice,productDesc,productStatus) " +
            "values (#{productNum}, #{productName}, #{cityName} , #{DepartureTime}, ${productPrice},#{productDesc},#{productStatus})")
    public void saveProduct(Product product);
}
