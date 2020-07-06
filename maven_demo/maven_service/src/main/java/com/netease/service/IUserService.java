package com.netease.service;

import com.netease.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService extends UserDetailsService {
    public List<User> findAll();
}
