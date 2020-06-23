package com.netease.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.netease.service.impl.AccountServiceImpl.transfer(..))")
    private void pointCut() {}

    public void begin() {
        try {
            Connection conn = connectionUtils.getThreadConnection();
            conn.setAutoCommit(false);
            System.out.println("begin transaction...");
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }
    }

    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("commit transaction...");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("rollback transaction...");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void release() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
            System.out.println("release connection...");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        Object returnValue = null;
        try {
            Object[] args = pjp.getArgs();
            begin();

            returnValue = pjp.proceed(args);

            commit();
            return returnValue;
        } catch (Throwable e) {
            rollback();
            throw new RuntimeException(e);
        } finally {
            release();
        }

    }


}
