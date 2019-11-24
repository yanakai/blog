package com.blog.sys.role.service;

import com.blog.sys.role.model.SysRoleInfo;

import java.util.List;
import java.util.Set;

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

    /**
     * @method:  checkRoleKeyUnique
     * @description: <p>验证角色可以是否存在</p>
     * @params:  sysRoleInfo
     * @return: java.lang.String
     * @date: 2019/11/9 15:20
     * @author: yanakai@126.com
     */
    String checkRoleKeyUnique(SysRoleInfo sysRoleInfo);

    /**
     * @method:  getMaxSort
     * @description: <p>获取最大的排序码</p>
     * @params:
     * @return: int
     * @date: 2019/11/9 16:00
     * @author: yanakai@126.com
     */
    int getMaxSort();

    /**
     * @method:  getRoleKeysByUserId
     * @description: <p>根据用户id查询角色的key</p>
     * @params:  userId 用户id
     * @return: java.util.Set<java.lang.String>
     * @date: 2019/11/12 22:56
     * @author: yanakai@126.com
     */
    Set<String> getRoleKeysByUserId(String userId);

    /**
     * @method:  getRoleListByUserId
     * @description: <p>通过用户id查询所拥有的角色</p>
     * @params:  userId 用户id
     * @return: java.util.List<com.blog.sys.role.model.SysRoleInfo>
     * @date: 2019/11/23 21:28
     * @author: yanakai@126.com
     */
    List<SysRoleInfo> getRoleListByUserId(String userId);

    /**
     * @method:  selectRoleAll
     * @description: <p>查询所有角色列表</p>
     * @params:
     * @return: java.util.List<com.blog.sys.role.model.SysRoleInfo>
     * @date: 2019/11/23 22:58
     * @author: yanakai@126.com       
     */
    public List<SysRoleInfo> selectRoleAll();

    /**
     * @method:  changeStatus
     * @description: <p>角色禁用和启用</p>
     * @params:  sysRoleInfo 角色对象
     * @return: int
     * @date: 2019/11/24 22:31
     * @author: yanakai@126.com
     */
    int changeStatus(SysRoleInfo sysRoleInfo);
}
