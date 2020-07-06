package com.netease.controlloer;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.netease.domain.Order;
import com.netease.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
@Transactional
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(name="page", required=true, defaultValue="1") Integer page,
            @RequestParam(name="size", required=true, defaultValue="2") Integer size) {
        ModelAndView mv = new ModelAndView();
        List<Order> orders = orderService.findAll(page, size);

        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name="id", required=true)Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findById(id);
        modelAndView.addObject("orders", order);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
