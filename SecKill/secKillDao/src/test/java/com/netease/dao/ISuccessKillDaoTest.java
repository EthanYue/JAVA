package com.netease.dao;
import com.netease.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class ISuccessKillDaoTest {

    @Resource
    private ISuccessKillDao ISuccessKillDao;

    @Test
    public void testInsertSuccessKilled() {
        int i = ISuccessKillDao.insertSuccessKilled(1000l, 19941490887l, (short)0);
        System.out.println(i);
    }

    @Test
    public void testQueryByIdWithSeckill() {
        SuccessKilled successKilled = ISuccessKillDao.queryByIdWithSeckill(1000l, 19941490887l);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}