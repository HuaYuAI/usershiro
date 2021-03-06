package com.shiro.service;

import com.shiro.pojo.EasyUIDatagridRequest;
import com.shiro.pojo.EasyUIDatagridResponse;
import com.shiro.pojo.Sysuser;
import com.shiro.pojo.Userdata;

/**
 * Created by huayu on 2018/7/1.
 */
public interface SysuserService {
    Sysuser findByUsername(String username);

    EasyUIDatagridResponse sysuserList(EasyUIDatagridRequest es);
}
