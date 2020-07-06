package com.netease.controlloer;

import com.netease.domain.Syslog;
import com.netease.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SyslogController {

    @Autowired
    private ISyslogService syslogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Syslog> syslogs = syslogService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sysLogs", syslogs);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
