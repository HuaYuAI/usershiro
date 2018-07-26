package com.shiro.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiro.mapper.SysuserMapper;
import com.shiro.pojo.EasyUIDatagridRequest;
import com.shiro.pojo.EasyUIDatagridResponse;
import com.shiro.pojo.Sysuser;
import com.shiro.pojo.SysuserExample;
import com.shiro.service.SysuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public EasyUIDatagridResponse sysuserList(EasyUIDatagridRequest es) {
        EasyUIDatagridResponse rs = new EasyUIDatagridResponse();
        //使用pageHelper
        //开始分页查询。aop
        PageHelper.startPage(es.getPage(),es.getRows());
        List<Sysuser> Sysuser = sysuserMapper.selectByExample(null);
        PageInfo<Sysuser> pg = new PageInfo<Sysuser>(Sysuser);
        //总条数
        rs.setTotal(pg.getTotal());
        //分页记录
        rs.setRows(pg.getList());
        return rs;
    }
}
