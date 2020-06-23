package com.netease.mybatis.io;

import java.io.InputStream;

/**
 * use classLoader to read a config file
 */
public class Resources {
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
