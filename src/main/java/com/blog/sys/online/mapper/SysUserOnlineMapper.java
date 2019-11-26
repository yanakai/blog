package com.blog.sys.online.mapper;

import com.blog.sys.online.model.SysUserOnline;

public interface SysUserOnlineMapper {
    int deleteByPrimaryKey(String sessionid);

    int insert(SysUserOnline record);

    int insertSelective(SysUserOnline record);

    SysUserOnline selectByPrimaryKey(String sessionid);

    int updateByPrimaryKeySelective(SysUserOnline record);

    int updateByPrimaryKey(SysUserOnline record);
}