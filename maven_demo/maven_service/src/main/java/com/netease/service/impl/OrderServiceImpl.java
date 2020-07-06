package com.netease.service.impl;

import com.github.pagehelper.PageHelper;
import com.netease.dao.IOrderDao;
import com.netease.domain.Order;
import com.netease.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    public List<Order> findAll(Integer page, Integer size) {

        PageHelper.startPage(page, size);
        List<Order> orders = orderDao.findAll();


        return orders;
    }

    public Order findById(Integer id) {
        return orderDao.findById(id);
    }
}
