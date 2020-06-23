package com.netease.mybatis.proxy;

import com.netease.mybatis.cfg.Mapper;
import com.netease.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    // key is class name + method name
    private Map<String, Mapper> mappers;
    private Connection conn;
    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.conn = conn;
        this.mappers = mappers;
    }

    /**
     * enhance method, to call selectList method
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className + "." + methodName;
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("param is wrong");
        }

        return new Executor().selectList(mapper, conn);
    }
}
