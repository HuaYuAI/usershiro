package com.huayu.shiro.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huayu on 2018/6/29.
 */
@Controller
public class JspDiapachController {

    @RequestMapping("/{page}")
    public ModelAndView jspDiapach(@PathVariable String page){
        ModelAndView modelAndView = new ModelAndView(page);
        modelAndView.setViewName(page);
        return modelAndView;
    }
}
