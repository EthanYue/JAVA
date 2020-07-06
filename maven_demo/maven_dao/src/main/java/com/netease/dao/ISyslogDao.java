package com.netease.dao;

import com.netease.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISyslogDao {

    @Insert("insert into syslog (visitTime, username, ip, url, executionTime, method) values (#{visitTime}, #{username}, #{ip}, #{url}, #{executionTime}, #{method})")
    public void save(Syslog syslog);

    @Select("select * from syslog")
    public List<Syslog> findAll();
}
