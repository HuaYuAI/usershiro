package com.huayu.shiro.service;


import com.huayu.shiro.common.dto.EasyUIDatagridRequest;
import com.huayu.shiro.common.dto.EasyUIDatagridResponse;
import com.huayu.shiro.pojo.Sysuser;

/**
 * Created by huayu on 2018/7/1.
 */
public interface SysuserService {
    Sysuser findByUsername(String username);

    EasyUIDatagridResponse sysuserList(EasyUIDatagridRequest es);
}
