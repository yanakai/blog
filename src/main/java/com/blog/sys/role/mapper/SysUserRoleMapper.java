package com.blog.sys.role.mapper;

import com.blog.sys.role.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * @method:  saveUserRole
     * @description: <p>批量保存用户角色信息</p>
     * @params:  list
     * @return: int
     * @date: 2019/11/10 15:21
     * @author: yanakai@126.com
     */
    int saveUserRole(@Param("list") List<SysUserRole> list);
}