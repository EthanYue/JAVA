package com.netease.service.impl;

import com.netease.dao.ISyslogDao;
import com.netease.domain.Syslog;
import com.netease.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("syslogService")
public class SyslogServiceImpl implements ISyslogService {

    @Autowired
    private ISyslogDao syslogDao;

    @Override
    public void save(Syslog syslog) {
        syslogDao.save(syslog);
    }

    public List<Syslog> findAll() {
        return syslogDao.findAll();
    }
}
