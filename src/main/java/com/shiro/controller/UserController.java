package com.shiro.controller;

import com.shiro.pojo.EasyUIDatagridRequest;
import com.shiro.pojo.EasyUIDatagridResponse;
import com.shiro.pojo.Userdata;
import com.shiro.pojo.EasyUITreeResponse;
import com.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by huayu on 2018/6/8.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/selectAll ", method = RequestMethod.GET)
    public EasyUIDatagridResponse selectAll(EasyUIDatagridRequest es){
        EasyUIDatagridResponse userList = userService.selectAll(es);
        return userList;
    }

}
