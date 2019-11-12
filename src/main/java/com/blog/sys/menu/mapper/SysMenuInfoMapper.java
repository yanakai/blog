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

    /**
     * @Title: checkMenuNameUnique
     * @Description:  校验同级别的菜单名称是否唯一
     * @Param: menuName 菜单名称
     * @Param: parentId 父级id
     * @return: com.blog.sys.menu.model.SysMenuInfo
     * @author: yankai
     * @date   2019/11/11
     */
    SysMenuInfo checkMenuNameUnique(@Param("parentId") String parentId,@Param("menuName")String menuName);

    /**
     * @Title: getMenuInfoById
     * @Description:  通过主键查询菜单信息 包含父级菜单名称
     * @Param: menuId 菜单主键
     * @return: com.blog.sys.menu.model.SysMenuInfo
     * @author: yankai
     * @date   2019/11/12 
     */ 
    SysMenuInfo getMenuInfoById(String menuId);

    /**
     * @Title: getChildMenuInfoById
     * @Description:  通过主键id查询其子菜单数据
     * @Param: menuId  菜单主键id
     * @return: java.util.List<com.blog.sys.menu.model.SysMenuInfo>
     * @author: yankai
     * @date   2019/11/12
     */
    List<SysMenuInfo> getChildMenuInfoById(String menuId);
}