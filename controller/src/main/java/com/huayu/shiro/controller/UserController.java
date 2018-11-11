package com.huayu.shiro.controller;

import com.huayu.shiro.common.dto.EasyUIDatagridRequest;
import com.huayu.shiro.common.dto.EasyUIDatagridResponse;
import com.huayu.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayu on 2018/6/8.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String sayHello(){
        return "hello springboot";
    }




/*    public EasyUIDatagridResponse selectAll(String page,String rows){

        return userList;
    }*/
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public EasyUIDatagridResponse list(EasyUIDatagridRequest es){
        EasyUIDatagridResponse rs = userService.userList(es);
        return rs;
    }

}
