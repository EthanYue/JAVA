package com.netease.service;
import com.netease.dto.Exposer;
import com.netease.entity.Seckill;
import com.netease.service.ISeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-service.xml")
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISeckillService seckillService;

    @Test
    public void testGetSeckillList() {
        List<Seckill> seckillList = seckillService.getSeckillList();
        for (Seckill seckill : seckillList) {
            System.out.println(seckill);
        }
    }

    @Test
    public void testGetById() {
        Seckill byId = seckillService.getById(1000l);
        System.out.println(byId);
    }

    @Test
    public void testExportSeckillUrl() {
        Exposer exposer = seckillService.exportSeckillUrl(1000l);
        System.out.println(exposer);
    }

    @Test
    public void testExecuteSeckill() {
    }
}