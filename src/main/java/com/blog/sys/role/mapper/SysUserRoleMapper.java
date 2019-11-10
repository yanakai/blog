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

    /**
     * @method:  deleteUserRole
     * @description: <p>批量删除角色用户信息</p>
     * @params:  roleId 角色id
     * @Param userIds 用户id是
     * @return: int
     * @date: 2019/11/10 17:01
     * @author: yanakai@126.com       
     */
    int deleteUserRole(@Param("roleId") String roleId, @Param("userIds")String[] userIds);
}