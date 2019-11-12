package com.blog.sys.menu.mapper;

import com.blog.sys.menu.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(SysRoleMenu key);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    /**
     * 批量删除角色菜单关联信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleMenu(@Param("roleIds") String[] roleIds);

    /**
     * @Title: insertRoleMenu
     * @Description:  批量保存角色菜单关联信息
     * @Param: list 角色菜单列表
     * @return: int
     * @author: yankai
     * @date   2019/11/12
     */
    int insertRoleMenu(@Param("list") List<SysRoleMenu> list);

    /**
     * 通过角色ID删除角色和菜单关联
     *
     * @param roleId 角色ID
     * @return 结果
     */
    /**
     * @Title: deleteRoleMenuByRoleId
     * @Description:  通过角色id删除角色菜单信息
     * @Param: roleId 角色id
     * @return: int
     * @author: yankai
     * @date   2019/11/12
     */
    public int deleteRoleMenuByRoleId(String roleId);
}