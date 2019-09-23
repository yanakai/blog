package com.yk.blog.column.mapper;

import com.yk.blog.column.model.SysColumnInfo;

import java.util.List;

public interface SysColumnInfoMapper {
    int deleteByPrimaryKey(String columnId);

    int insert(SysColumnInfo record);

    int insertSelective(SysColumnInfo record);

    SysColumnInfo selectByPrimaryKey(String columnId);

    int updateByPrimaryKeySelective(SysColumnInfo record);

    int updateByPrimaryKey(SysColumnInfo record);

    /**
     * @method:  getList
     * @description: <p>通过对象查询列表信息</p>
     * @params:  [sysColumnInfo]
     * @return java.util.List<com.yk.blog.column.model.SysColumnInfo>
     * @date: 2019/9/23 22:13
     * @author: yanakai@126.com
     */
    List<SysColumnInfo> getList(SysColumnInfo sysColumnInfo);

    /**
     * @method:  checkColumnNameUnique
     * @description: <p>校验栏目名称是否已存在</p>
     * @params:  [columnName]
     * @return com.yk.blog.column.model.SysColumnInfo
     * @date: 2019/9/23 23:24
     * @author: yanakai@126.com
     */
    SysColumnInfo checkColumnNameUnique(String columnName);
}