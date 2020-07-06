package com.netease.dao;

import com.netease.entity.Seckill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface ISecKillDao {
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    public int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据ID查询秒杀对象
     * @param seckillId
     * @return
     */
    public Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    public List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
