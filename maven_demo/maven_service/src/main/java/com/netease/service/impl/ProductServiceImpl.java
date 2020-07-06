package com.netease.service.impl;

import com.netease.dao.IProductDao;
import com.netease.domain.Product;
import com.netease.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public List<Product> findAll() {
        List<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
        return products;
    }

    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }
}
