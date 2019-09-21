package com.yk.blog.column.mapper;

import com.yk.blog.column.model.sysColumnInfo;

public interface sysColumnInfoMapper {
    int deleteByPrimaryKey(String columnId);

    int insert(sysColumnInfo record);

    int insertSelective(sysColumnInfo record);

    sysColumnInfo selectByPrimaryKey(String columnId);

    int updateByPrimaryKeySelective(sysColumnInfo record);

    int updateByPrimaryKey(sysColumnInfo record);
}