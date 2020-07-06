package com.netease.service;

import com.netease.domain.Member;
import com.netease.domain.Order;

import java.util.List;

public interface IMemberService {
    public List<Member> findAll(Integer page, Integer size);
}
