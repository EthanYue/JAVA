package com.netease.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringtoDateConvert implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if(s == null) {
            throw new RuntimeException("invalid args");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("parse date error");
        }
    }
}
