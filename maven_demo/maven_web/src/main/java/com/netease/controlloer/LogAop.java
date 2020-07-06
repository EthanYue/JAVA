package com.netease.controlloer;

import com.netease.domain.Syslog;
import org.springframework.security.core.userdetails.User;
import com.netease.service.ISyslogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISyslogService syslogService;

    private Date visitTime;
    private Class clazz;
    private Method method;
    private String url;

    @Before("execution(* com.netease.controlloer.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            Method method = clazz.getMethod(methodName, classArgs);
        }

    }

    @After("execution(* com.netease.controlloer.*.*(..))")
    public void doAfter(JoinPoint jp) {
        long time = new Date().getTime() - visitTime.getTime();
        // get url
        if (clazz != null && method != null && clazz != LogAop.class) {
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValues = classAnnotation.value();

                RequestMapping methodAnnotation = (RequestMapping) method.getAnnotation(RequestMapping.class);

                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValues[0] + methodValue[0];
                }

            }
        }

        //get ip
        String ip = request.getRemoteAddr();
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User)context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        String methodStr = clazz.getName() + "/" + method.getName();

        Syslog syslog = new Syslog(visitTime, username, ip, url, time, methodStr);

        syslogService.save(syslog);
    }

}
