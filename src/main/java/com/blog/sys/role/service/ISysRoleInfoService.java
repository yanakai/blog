package com.blog.sys.role.service;

import com.blog.sys.role.model.SysRoleInfo;

import java.util.List;

public interface ISysRoleInfoService {
    /**
     * @Title: getList
     * @Description:  获取角色列表数据
     * @Param: sysRoleInfo  角色对象
     * @return: java.util.List<com.blog.sys.role.model.SysRoleInfo>
     * @author: yankai
     * @date   2019/11/8
     */
    List<SysRoleInfo> getList(SysRoleInfo sysRoleInfo);

    /**
     * @Title: getById
     * @Description:  通过主键查询对象信息
     * @Param: roleId 主键id
     * @return: com.blog.sys.role.model.SysRoleInfo
     * @author: yankai
     * @date   2019/11/8
     */
    SysRoleInfo getById(String roleId);

    /**
     * @Title: updateNotNull
     * @Description:  修改不为空的数据
     * @Param: sysRoleInfo 角色对象
     * @return: int
     * @author: yankai
     * @date   2019/11/8
     */
    int updateNotNull(SysRoleInfo sysRoleInfo);

    /**
     * @Title: saveNotNull
     * @Description:  保存不为空的数据
     * @Param: sysRoleInfo 角色对象
     * @return: int
     * @author: yankai
     * @date   2019/11/8
     */
    int saveNotNull(SysRoleInfo sysRoleInfo);

    /**
     * @Title: deleteById
     * @Description:  通过主键删除角色
     * @Param: roleId  角色id
     * @return: int
     * @author: yankai
     * @date   2019/11/8
     */
    int deleteById(String roleId);

    /**
     * @method:  checkRoleNameUnique
     * @description: <p>验证角色名称是否唯一</p>
     * @params:  sysRoleInfo
     * @return: java.lang.String
     * @date: 2019/11/8 22:48
     * @author: yanakai@126.com
     */
    String checkRoleNameUnique(SysRoleInfo sysRoleInfo);
}
