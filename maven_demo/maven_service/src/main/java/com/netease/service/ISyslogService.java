package com.netease.service;

import com.netease.domain.Syslog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISyslogService {
    public void save(Syslog syslog);

    public List<Syslog> findAll();
}
