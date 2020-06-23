package com.netease.mybatis.sqlsession;


/**
 * a core class that interacts with database
 * create a proxy Object of Dao Interface
 */
public interface SqlSession {
    /**
     * create proxy Object according to param
     * @param daoInterfaceClass a interface bytecode of Dao
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * release resources;
     */
    void close();
}
