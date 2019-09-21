package com.yk.blog.column.mapper;

import com.yk.blog.column.model.SysColumnInfo;

public interface SysColumnInfoMapper {
    int deleteByPrimaryKey(String columnId);

    int insert(SysColumnInfo record);

    int insertSelective(SysColumnInfo record);

    SysColumnInfo selectByPrimaryKey(String columnId);

    int updateByPrimaryKeySelective(SysColumnInfo record);

    int updateByPrimaryKey(SysColumnInfo record);
}