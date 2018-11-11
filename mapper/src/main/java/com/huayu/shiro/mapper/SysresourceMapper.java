package com.huayu.shiro.mapper;

import com.huayu.shiro.pojo.Sysresource;
import com.huayu.shiro.pojo.SysresourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysresourceMapper {
    int countByExample(SysresourceExample example);

    int deleteByExample(SysresourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sysresource record);

    int insertSelective(Sysresource record);

    List<Sysresource> selectByExample(SysresourceExample example);

    Sysresource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sysresource record, @Param("example") SysresourceExample example);

    int updateByExample(@Param("record") Sysresource record, @Param("example") SysresourceExample example);

    int updateByPrimaryKeySelective(Sysresource record);

    int updateByPrimaryKey(Sysresource record);
}