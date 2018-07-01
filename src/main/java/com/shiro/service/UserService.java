package com.shiro.service;

import com.shiro.pojo.EasyUIDatagridRequest;
import com.shiro.pojo.EasyUIDatagridResponse;
import com.shiro.pojo.Userdata;

/**
 * Created by huayu on 2018/6/19.
 */
public interface UserService {

    //添加用户
    public int add(Userdata userdata) ;

    //修改用户,只修改有用的参数。
    public boolean update(Userdata userdata) ;

    //删除用户
    public int delete(Userdata user) ;

    //查询所有用户
    EasyUIDatagridResponse userList(EasyUIDatagridRequest es);
}
