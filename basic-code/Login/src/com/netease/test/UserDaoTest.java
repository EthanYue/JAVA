package com.netease.test;

import com.netease.dao.UserDao;
import com.netease.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("yuefeiyu");
        loginUser.setPassword("yuefeiyu");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);

    }
}
