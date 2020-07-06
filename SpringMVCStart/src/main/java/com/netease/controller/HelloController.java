package com.netease.controller;

import com.netease.domain.Account;
import com.netease.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/test")
public class HelloController {

    @RequestMapping(path="/hello")
    public String sayHello(String username) {
        System.out.println("Hello " + username);
        return "success";
    }

    @RequestMapping(path="/hello1", method={GET, POST})
    public String sayHello1() {
        System.out.println("Hello1");
        return "success";
    }

    @RequestMapping(path="formTest", method={POST})
    public String saveAccount(Account account) {
        System.out.println(account);
        return "success";
    }

    @RequestMapping(path="saveUser", method={POST})
    public String saveUser(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping(path="testServlet")
    public String testServlet(HttpServletRequest req, HttpServletResponse rep) {
        HttpSession session = req.getSession();
        System.out.println(session);
        System.out.println(session.getServletContext());
        System.out.println(rep);
        return "success";
    }
}
