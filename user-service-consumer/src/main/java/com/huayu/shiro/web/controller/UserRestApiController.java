package com.huayu.shiro.web.controller;

import com.huayu.shiro.api.user.User;
import com.huayu.shiro.api.user.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by huayu on 2019/6/1.
 */
@RestController
public class UserRestApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setUsername(name);
        if (userService.save(user)){
            return user;
        }else {
            return null;
        }
    }

    @GetMapping("/user/list")
    public Collection<User> list(){
        return userService.findAll();
    }
}
