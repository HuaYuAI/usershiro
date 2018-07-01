package com.shiro.controller;

import com.shiro.pojo.*;
import com.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping(value = "/loginSystem", method = RequestMethod.POST)
    public E3Result loginSystem(String username, String password, HttpServletRequest request){
        //创建shiro使用的subject主体
        Subject subject = SecurityUtils.getSubject();
        //生成token值
        UsernamePasswordToken token =
                new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (Exception e) {
            return  E3Result.build(222,"用户名或者密码错误");
        }
        return E3Result.ok();
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
