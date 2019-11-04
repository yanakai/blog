package com.blog.sys.user.mapper;

import com.blog.sys.user.model.SysUserInfo;

public interface SysUserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);
}