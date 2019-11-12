package com.blog.sys.menu.service;

import com.blog.sys.menu.model.SysMenuInfo;

import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.menu.service
 * @ClassName: ISysMenuInfoService
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/10 20:55
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/10 20:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysMenuInfoService {
    /**
     * @Title: getMenuList
     * @Description:  查看所有菜单数据
     * @Param: sysMenuInfo
     * @return: java.util.List<com.blog.sys.menu.model.SysMenuInfo>
     * @author: yankai
     * @date   2019/11/11
     */
    List<SysMenuInfo> getMenuList(SysMenuInfo sysMenuInfo);

    /**
     * @Title: getById
     * @Description:  通过主键查询对象
     * @Param: menuId
     * @return: com.blog.sys.menu.model.SysMenuInfo
     * @author: yankai
     * @date   2019/11/11
     */
    SysMenuInfo getById(String menuId);

    /**
     * @Title: getMaxSortByParentId
     * @Description:  获取同一级别的菜单最大的排序码
     * @Param: parentId 菜单父id
     * @return: int
     * @author: yankai
     * @date   2019/11/11
     */
    int getMaxSortByParentId(String parentId);

    /**
     * @Title: updateNotNull
     * @Description: 根据主键修改不为空的数据
     * @Param: sysMenuInfo
     * @return: int
     * @author: yankai
     * @date   2019/11/11
     */
    int updateNotNull(SysMenuInfo sysMenuInfo);

    /**
     * @Title: saveNotNull
     * @Description:  保存不为的数据
     * @Param: sysMenuInfo
     * @return: int
     * @author: yankai
     * @date   2019/11/11
     */
    int saveNotNull(SysMenuInfo sysMenuInfo);

    /**
     * @Title: deleteIdById
     * @Description:  通过主键删除信息
     * @Param: menuId  菜单id
     * @return: int
     * @author: yankai
     * @date   2019/11/11
     */
    int deleteById(String menuId);

    /**
     * @Title: checkMenuNameUnique
     * @Description:  校验同级别的菜单名称是否唯一
     * @Param: sysMenuInfo 
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/11 
     */ 
    String checkMenuNameUnique(SysMenuInfo sysMenuInfo);

    /**
     * @Title: getMenuInfoById
     * @Description:  通过主键查询菜单信息 包含父级菜单名称
     * @Param: menuId  菜单主键
     * @return: com.blog.sys.menu.model.SysMenuInfo
     * @author: yankai
     * @date   2019/11/12
     */
    SysMenuInfo getMenuInfoById(String menuId);

    /**
     * @Title: getChildMenuInfoById
     * @Description:  通过追按id查询其子菜单数据
     * @Param: menuId 菜单id'
     * @return: java.util.List<com.blog.sys.menu.model.SysMenuInfo>
     * @author: yankai
     * @date   2019/11/12
     */
    List<SysMenuInfo> getChildMenuInfoById(String menuId);
}
