package com.blog.sys.role.mapper;

import com.blog.sys.role.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    /**
     * @method:  deleteUserRoleInfo
     * @description: <p>删除用户角色信息</p>
     * @params:  sysUserRole
     * @return: int
     * @date: 2019/11/10 13:20
     * @author: yanakai@126.com
     */
    int deleteUserRoleInfo(@Param("vo") SysUserRole sysUserRole);
}