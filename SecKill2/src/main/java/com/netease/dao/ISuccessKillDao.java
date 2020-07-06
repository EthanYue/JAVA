package com.netease.dao;

import com.netease.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

public interface ISuccessKillDao {

    /**
     * 插入购买明细
     * @param seckillId
     * @param userPhone
     * @return
     */
    public int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone, @Param("state") short state);

    /**
     * 根据id查询SuccessKilled并携带Seckill实体对象
     * @param seckillId
     * @return
     */
    public SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
