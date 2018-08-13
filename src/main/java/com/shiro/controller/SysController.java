package com.shiro.controller;

import com.shiro.pojo.*;
import com.shiro.pojo.E3Result;
import com.shiro.pojo.EasyUIDatagridRequest;
import com.shiro.pojo.EasyUIDatagridResponse;
import com.shiro.common.dto.*;
import com.shiro.service.SysuserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huayu on 2018/7/2.
 */
@RestController
public class SysController {
    @Autowired
    SysuserService sysuserService;

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

    @RequestMapping(value = "/sysuserList", method = RequestMethod.GET)
    public EasyUIDatagridResponse list(EasyUIDatagridRequest es){
        EasyUIDatagridResponse rs = sysuserService.sysuserList(es);
        return rs;
    }
    @RequestMapping(value = "/sysTree", method = RequestMethod.POST)
    public EasyUITreeResponse[] systTree(EasyUIDatagridRequest es){
        EasyUITreeResponse [] rs =new EasyUITreeResponse[1];
        EasyUITreeResponse [] rs3 =new EasyUITreeResponse[1];
        EasyUITreeResponse rs1 = new EasyUITreeResponse();
        rs1.setId(123467897411236L);
        rs1.setState("1");
        rs1.setText("测试");
        rs1.setIconCls("tree-folder");
        EasyUITreeResponse rs2 = new EasyUITreeResponse();
        rs2.setId(123467897411236L);
        //rs2.setState("0");
        rs2.setText("测试");
        rs2.setIconCls("tree-folder");
        Attributes attributes = new Attributes();
        attributes.setUrl("list");
        // rs2.setAttributes(attributes);
        rs3[0]=rs2;
        rs1.setChildren(rs3);
        rs[0]=rs1;
        return rs;
    }
}
