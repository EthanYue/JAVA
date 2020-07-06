package com.netease.test;

import com.netease.dao.ItemsDao;
import com.netease.domain.Items;
import com.netease.service.IItemsService;
import com.netease.service.impl.ItemsServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsTest {
    @Test
    public void findById() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
//        Items items = itemsDao.findById(1);
//        System.out.println(items);
        IItemsService itemsService = ac.getBean(IItemsService.class);
        Items items = itemsService.findById(1);
        System.out.println(items);
    }
}
