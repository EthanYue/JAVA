package com.netease.test;

import com.netease.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.beans.factory.parsing.BeanEntry;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user, "username", "yuefeiyu");
        System.out.println(user);

        String password = BeanUtils.getProperty(user, "password");
        System.out.println(password);
    }
}
