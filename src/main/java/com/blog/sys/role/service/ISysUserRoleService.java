package com.blog.sys.role.service;

import com.blog.sys.role.model.SysUserRole;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.role.service
 * @ClassName: ISysUserRoleService
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/9 17:22
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/9 17:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysUserRoleService {
    /**
     * @method:  deleteUserRoleInfo
     * @description: <p>删除用户角色信息</p>
     * @params:  sysUserRole
     * @return: int
     * @date: 2019/11/10 13:23
     * @author: yanakai@126.com
     */
    int deleteUserRoleInfo(SysUserRole sysUserRole);

    /**
     * @method:  saveUserRole
     * @description: <p>批量保存用户角色信息</p>
     * @params:  roleId
     * @Param userIds
     * @return: int
     * @date: 2019/11/10 15:11
     * @author: yanakai@126.com
     */
    int saveUserRole(String roleId, String userIds);

    /**
     * @method:  deleteUserRole
     * @description: <p> 批量删除用户角色信息</p>
     * @params:  roleId 角色id
     * @Param userIds 用户ids
     * @return: int
     * @date: 2019/11/10 16:53
     * @author: yanakai@126.com
     */
    int deleteUserRole(String roleId, String userIds);
}
