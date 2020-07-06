package com.netease.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException sysException = null;
        if (e instanceof SysException) {
            e = (SysException) e;
        } else {
            e = new SysException("has exception");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
