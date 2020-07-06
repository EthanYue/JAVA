package com.netease.controlloer;

import com.netease.domain.User;
import com.netease.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Transactional
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", users);
        modelAndView.setViewName("uselist");
        return modelAndView;
    }

}
