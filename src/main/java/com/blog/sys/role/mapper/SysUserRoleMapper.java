package com.blog.sys.role.mapper;

import com.blog.sys.role.model.SysUserRole;

public interface SysUserRoleMapper {

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}