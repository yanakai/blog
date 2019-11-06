package com.blog.sys.user.mapper;

import com.blog.sys.user.model.SysUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);

    /**
     * @method:  getList
     * @description: <p>获取用户列表信息</p>
     * @params:  sysUserInfo
     * @return: java.util.List<com.blog.sys.user.model.SysUserInfo>
     * @date: 2019/11/6 21:31
     * @author: yanakai@126.com
     */
    List<SysUserInfo> getList(@Param("vo") SysUserInfo sysUserInfo);
}