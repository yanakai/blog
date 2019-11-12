package com.blog.sys.role.mapper;

import com.blog.sys.role.model.SysRoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleInfoMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRoleInfo record);

    int insertSelective(SysRoleInfo record);

    SysRoleInfo selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRoleInfo record);

    int updateByPrimaryKey(SysRoleInfo record);

    /**
     * @Title: getList
     * @Description:  获取角色列表数据
     * @Param: sysRoleInfo 角色对象
     * @return: java.util.List<com.blog.sys.role.model.SysRoleInfo>
     * @author: yankai
     * @date   2019/11/8
     */
    List<SysRoleInfo> getList(@Param("vo") SysRoleInfo sysRoleInfo);

    /**
     * @method:  checkRoleNameUnique
     * @description: <p>验证角色名称是否唯一</p>
     * @params:  roleName
     * @return: com.blog.sys.role.model.SysRoleInfo
     * @date: 2019/11/8 22:53
     * @author: yanakai@126.com
     */
    SysRoleInfo checkRoleNameUnique(String roleName);

    /**
     * @method:  checkRoleKeyUnique
     * @description: <p>验证角色key是否唯一</p>
     * @params:  roleKey
     * @return: com.blog.sys.role.model.SysRoleInfo
     * @date: 2019/11/9 15:24
     * @author: yanakai@126.com
     */
    SysRoleInfo checkRoleKeyUnique(String roleKey);

    /**
     * @method:  getMaxSort
     * @description: <p>获取最大的排序码</p>
     * @params:
     * @return: int
     * @date: 2019/11/9 16:01
     * @author: yanakai@126.com
     */
    int getMaxSort();

    /**
     * @method:  getRoleListByUserId
     * @description: <p>根据用户id查询用户的角色列表</p>
     * @params:  userId
     * @return: java.util.List<com.blog.sys.role.model.SysRoleInfo>
     * @date: 2019/11/12 22:58
     * @author: yanakai@126.com
     */
    List<SysRoleInfo> getRoleListByUserId(String userId);
}