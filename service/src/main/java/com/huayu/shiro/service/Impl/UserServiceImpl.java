package com.huayu.shiro.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huayu.shiro.common.dto.EasyUIDatagridRequest;
import com.huayu.shiro.common.dto.EasyUIDatagridResponse;
import com.huayu.shiro.mapper.UserdataMapper;
import com.huayu.shiro.pojo.Userdata;
import com.huayu.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserdataMapper userdataMapper;
	
	//添加用户
	public int add(Userdata userdata) {
		return userdataMapper.insertSelective(userdata);
	}
	//修改用户,只修改有用的参数。
	public boolean update(Userdata userdata) {
		return userdataMapper.updateByPrimaryKeySelective(userdata) > 0;
	}
	//删除用户
	public int delete(Userdata user) {
		return userdataMapper.deleteByPrimaryKey(user.getUid());
	}

	@Override
	public EasyUIDatagridResponse userList(EasyUIDatagridRequest es) {
		EasyUIDatagridResponse rs = new EasyUIDatagridResponse();
		//使用pageHelper
		//开始分页查询。aop
		PageHelper.startPage(es.getPage(),es.getRows());
		List<Userdata> userdata = userdataMapper.selectByExample(null);
		PageInfo<Userdata> pg = new PageInfo<Userdata>(userdata);
		//总条数
		rs.setTotal(pg.getTotal());
		//分页记录
		rs.setRows(pg.getList());
		return rs;
	}

}
