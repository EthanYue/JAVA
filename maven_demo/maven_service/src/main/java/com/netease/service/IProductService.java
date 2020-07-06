package com.netease.service;

import com.netease.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public void saveProduct(Product product);
}
