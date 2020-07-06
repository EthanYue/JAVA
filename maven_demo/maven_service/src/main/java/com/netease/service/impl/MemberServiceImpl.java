package com.netease.service.impl;

import com.github.pagehelper.PageHelper;
import com.netease.dao.IMemberDao;
import com.netease.dao.IOrderDao;
import com.netease.domain.Member;
import com.netease.domain.Order;
import com.netease.service.IMemberService;
import com.netease.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private IMemberDao memberDao;

    public List<Member> findAll(Integer page, Integer size) {

        PageHelper.startPage(page, size);
        List<Member> members = memberDao.findAll();

        return members;
    }
}
