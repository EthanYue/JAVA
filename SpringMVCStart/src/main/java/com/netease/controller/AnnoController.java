package com.netease.controller;

import com.netease.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"msg"})  // storage "msg" attr from request scope into session scope, and the variable of session scope will be shared by other method
public class AnnoController {
    @RequestMapping("/testParam")
    /*
    @RequestParam has 'name' attribute which define the param name of requests
     */
    public String testParam(@RequestParam(name="name") String username) {
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable String sid) {
        System.out.println(sid);
        return "success";
    }

    @RequestMapping("/testModelAttr")
    public String testModelAttr(User user) {
        System.out.println(user);
        return "success";
    }

    @ModelAttribute  // @ModelAttribute can invoke method before request method
    public User before(String username) {
        User user = new User();
        user.setName(username);
        user.setAge(19);
        user.setDate(new Date());
        return user;
    }

    @RequestMapping("/testModelAttr1")
    public String testModelAttr1(@ModelAttribute("one") User user) {
        System.out.println(user);
        return "success";
    }

    @ModelAttribute  // @ModelAttribute can invoke method before request method
    public void before1(String username, Map<String, User> map) {
        User user = new User();
        user.setName(username);
        user.setAge(19);
        user.setDate(new Date());
        map.put("one", user);
    }

    @RequestMapping("/testSessionAttr")
    public String testSessionAttr(Model model) {
        model.addAttribute("msg", "yuefeiyu");
        return "success";
    }

    @RequestMapping("/testGetSessionAttr")
    public String testGetSessionAttr(ModelMap modelMap) {
        Object msg = modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/testDelSessionAttr")
    public String testDelSessionAttr(SessionStatus status) {
        status.setComplete();
        return "success";
    }
}
