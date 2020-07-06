package com.netease.utils;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.util.Date;

public class DateStringEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Date date = null;
        try {
            date = DateUtils.StringToDate(text, "yyyy-MM-dd HH:mm");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        super.setValue(date);
    }
}
