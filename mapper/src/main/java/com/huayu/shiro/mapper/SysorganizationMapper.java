package com.huayu.shiro.mapper;

import com.huayu.shiro.pojo.Sysorganization;
import com.huayu.shiro.pojo.SysorganizationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysorganizationMapper {
    int countByExample(SysorganizationExample example);

    int deleteByExample(SysorganizationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sysorganization record);

    int insertSelective(Sysorganization record);

    List<Sysorganization> selectByExample(SysorganizationExample example);

    Sysorganization selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sysorganization record, @Param("example") SysorganizationExample example);

    int updateByExample(@Param("record") Sysorganization record, @Param("example") SysorganizationExample example);

    int updateByPrimaryKeySelective(Sysorganization record);

    int updateByPrimaryKey(Sysorganization record);
}