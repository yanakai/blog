package com.blog.sys.menu.mapper;

import com.blog.sys.menu.model.SysRoleMenu;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(SysRoleMenu key);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);
}