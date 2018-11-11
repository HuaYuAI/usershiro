package com.huayu.shiro.mapper;

import com.huayu.shiro.pojo.Userdata;
import com.huayu.shiro.pojo.UserdataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserdataMapper {
    int countByExample(UserdataExample example);

    int deleteByExample(UserdataExample example);

    int deleteByPrimaryKey(String uid);

    int insert(Userdata record);

    int insertSelective(Userdata record);

    List<Userdata> selectByExample(UserdataExample example);

    Userdata selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") Userdata record, @Param("example") UserdataExample example);

    int updateByExample(@Param("record") Userdata record, @Param("example") UserdataExample example);

    int updateByPrimaryKeySelective(Userdata record);

    int updateByPrimaryKey(Userdata record);
}