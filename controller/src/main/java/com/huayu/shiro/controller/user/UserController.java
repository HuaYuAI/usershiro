package com.huayu.shiro.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayu on 2018/6/8.
 */
@RestController
public class UserController {

    @GetMapping("/test")
    public String sayHello(){
        return "I love HuaYu";
    }


}
