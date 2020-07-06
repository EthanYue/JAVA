package com.netease.service.impl;
import com.netease.dao.IUserDao;
import com.netease.domain.Role;
import com.netease.domain.User;
import com.netease.service.IUserService;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByName(s);
        org.springframework.security.core.userdetails.User userDetail =
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        "{noop}" + user.getPassword(),
                        user.getStatus() == 1,
                        true,
                        true,
                        true,
                        getAuthority(user.getRoles()));
        return userDetail;
    }

    public List<SimpleGrantedAuthority> getAuthority (List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDao.findAll();
        return users;
    }
}
