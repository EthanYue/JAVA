package com.netease.service;

import com.netease.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;

public interface IOrderService {
    public List<Order> findAll(Integer page, Integer size);
    public Order findById(Integer id);
}
