package com.blog.sys.menu.mapper;

import com.blog.sys.menu.model.SysMenuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuInfoMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(SysMenuInfo record);

    int insertSelective(SysMenuInfo record);

    SysMenuInfo selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(SysMenuInfo record);

    int updateByPrimaryKey(SysMenuInfo record);

    /**
     * @Title: getMenuList
     * @Description:  查询菜单列表
     * @Param: sysMenuInfo
     * @return: java.util.List<com.blog.sys.menu.model.SysMenuInfo>
     * @author: yankai
     * @date   2019/11/11
     */
    List<SysMenuInfo> getMenuList(@Param("vo") SysMenuInfo sysMenuInfo);

    /**
     * @Title: getMaxSortByParentId
     * @Description:  获取同一级别的菜单最大的排序码
     * @Param: parentId 父id
     * @return: int
     * @author: yankai
     * @date   2019/11/11 
     */ 
    int getMaxSortByParentId(String parentId);
}