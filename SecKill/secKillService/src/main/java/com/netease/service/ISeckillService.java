package com.netease.service;

import com.netease.dto.Exposer;
import com.netease.dto.SeckillExecution;
import com.netease.entity.Seckill;
import com.netease.exception.SeckillCloseException;
import com.netease.exception.SeckillException;
import com.netease.exception.SeckillRepeatException;

import java.util.List;

public interface ISeckillService {
    /**
     * 查询所有描述记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开始输出秒杀接口地址
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
    throws SeckillCloseException, SeckillRepeatException, SeckillException;
}
