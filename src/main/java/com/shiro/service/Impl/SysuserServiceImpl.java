package com.shiro.service.Impl;

import com.shiro.mapper.SysuserMapper;
import com.shiro.pojo.Sysuser;
import com.shiro.pojo.SysuserExample;
import com.shiro.service.SysuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huayu on 2018/7/1.
 */
@Service("sysuserService")
public class SysuserServiceImpl implements SysuserService {
    @Autowired
    private SysuserMapper sysuserMapper;
    @Override
    public Sysuser findByUsername(String username) {
        SysuserExample sysuserExample = new SysuserExample();
        SysuserExample.Criteria criteria = sysuserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return sysuserMapper.selectByExample(sysuserExample).get(0);
    }
}
