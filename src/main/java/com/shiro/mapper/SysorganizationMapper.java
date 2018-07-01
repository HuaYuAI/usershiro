package com.shiro.mapper;

import com.shiro.pojo.Sysorganization;
import com.shiro.pojo.SysorganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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