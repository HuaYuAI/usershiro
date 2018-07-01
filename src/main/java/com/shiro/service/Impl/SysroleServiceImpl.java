package com.shiro.service.Impl;

import com.shiro.mapper.SysroleMapper;
import com.shiro.pojo.Sysrole;
import com.shiro.service.SysroleService;
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
