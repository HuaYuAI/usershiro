package com.huayu.shiro.service.Impl;

import com.huayu.shiro.mapper.SysroleMapper;
import com.huayu.shiro.pojo.Sysrole;
import com.huayu.shiro.service.SysroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huayu on 2018/7/1.
 */
@Service("sysroleService")
public class SysroleServiceImpl implements SysroleService {
    @Autowired
    private SysroleMapper sysroleMapper;

    @Override
    public Sysrole selecetByRid(String id) {
        return sysroleMapper.selectByPrimaryKey(Long.parseLong(id));
    }
}
