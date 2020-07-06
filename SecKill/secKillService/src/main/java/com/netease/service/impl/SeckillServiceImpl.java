package com.netease.service.impl;

import com.netease.dao.ISecKillDao;
import com.netease.dao.ISuccessKillDao;
import com.netease.dto.Exposer;
import com.netease.dto.SeckillExecution;
import com.netease.entity.Seckill;
import com.netease.entity.SuccessKilled;
import com.netease.enums.SeckillStatEnum;
import com.netease.exception.SeckillCloseException;
import com.netease.exception.SeckillException;
import com.netease.exception.SeckillRepeatException;
import com.netease.service.ISeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.parameters.P;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.rmi.PortableRemoteObject;
import java.util.Date;
import java.util.List;

@Service("seckillService")
public class SeckillServiceImpl implements ISeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISecKillDao secKillDao;

    @Autowired
    private ISuccessKillDao successKillDao;

    private final String slat = "asdlfkjsdnlknrlr23k4n1l2k3nL%NL4KN5";

    public List<Seckill> getSeckillList() {
        return secKillDao.queryAll(0, 4);
    }

    public Seckill getById(long seckillId) {
        return secKillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = secKillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);

    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillCloseException, SeckillRepeatException, SeckillException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }

        try {
            Date now = new Date();
            // 减库存
            int updateCnt = secKillDao.reduceNumber(seckillId, now);
            if (updateCnt <= 0) {
                throw new SeckillCloseException("seckill is closed");
            } else {
                // 秒杀成功插入
                int insertCnt = successKillDao.insertSuccessKilled(seckillId, userPhone, (short)1);
                if (insertCnt <= 0) {
                    throw new SeckillRepeatException("seckill repeated");
                } else {
                    // 返回秒杀结果
                    SuccessKilled successKilled = successKillDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (SeckillRepeatException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SeckillException("seckill inner error: " + e.getMessage());
        }
    }
}
