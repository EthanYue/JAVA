package com.netease.dao;

import com.netease.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

// combine spring with junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class SecKillDaoTest{

    @Resource
    private ISecKillDao ISecKillDao;

    @Test
    public void testReduceNumber() {
        int i = ISecKillDao.reduceNumber(1000l, new Date());
        System.out.println(i);
    }

    @Test
    public void testQueryById() {
        Seckill seckill = ISecKillDao.queryById(1000l);
        System.out.println(seckill);
    }

    @Test
    public void testQueryAll() throws Exception{
        List<Seckill> seckills = ISecKillDao.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }
}