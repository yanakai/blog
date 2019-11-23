package com.blog.sys.menu.controller;

import cn.hutool.core.lang.UUID;
import com.blog.sys.common.annotation.Log;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.model.Ztree;
import com.blog.sys.common.enums.BusinessType;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.menu.model.SysMenuInfo;
import com.blog.sys.menu.service.ISysMenuInfoService;
import com.blog.sys.role.model.SysRoleInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.menu.controller
 * @ClassName: SysMenuInfoController
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/10 21:04
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/10 21:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sys/menu")
public class SysMenuInfoController extends BaseController {
    private final static String SYS_MENU_PATH = "/sys/menu";
    @Resource
    private ISysMenuInfoService sysMenuInfoService;

    /**
     * @Title: pageList
     * @Description:  跳转至菜单列表页面
     * @Param: request
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/11
     */
    @RequiresPermissions("sys:menu:view")
    @GetMapping("/list")
    public String pageList(HttpServletRequest request, ModelMap modelMap){
        return SYS_MENU_PATH + "/list";
    }
    /**
     * @method:  tableDataList
     * @description: <p>获取菜单列表数据</p>
     * @params:  request
     * @Param sysMenuInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/11/10 21:10
     * @author: yanakai@126.com
     */
    @Log(title = "菜单管理-->列表页面", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:menu:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysMenuInfo> tableDataList(HttpServletRequest request, SysMenuInfo sysMenuInfo){
        List<SysMenuInfo> list = sysMenuInfoService.getMenuList(sysMenuInfo);
        return list;
    }

    /**
     * 选择菜单图标
     */
    @GetMapping("/icon")
    public String icon(HttpServletRequest request){
        return SYS_MENU_PATH + "/icon";
    }

    /**
     * @Title: add
     * @Description:  跳转至添加页面
     * @Param: request
     * @Param parentId
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/11
     */
    @Log(title = "菜单管理-->添加页面", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:menu:add")
    @GetMapping("/add/{parentId}")
    public String add(HttpServletRequest request,@PathVariable("parentId") String parentId,ModelMap modelMap){
        SysMenuInfo sysMenuInfo = new SysMenuInfo();
        if ("root".equals(parentId)){
            sysMenuInfo.setMenuId("root");
            sysMenuInfo.setMenuName("根目录");
        }else {
            sysMenuInfo = sysMenuInfoService.getById(parentId);
        }
        int maxSort = sysMenuInfoService.getMaxSortByParentId(parentId);
        sysMenuInfo.setOrderNum(maxSort + 1);
        modelMap.put("info",sysMenuInfo);
        return SYS_MENU_PATH + "/add";
    }

    /**
     * @Title: edit
     * @Description:  跳转至菜单编辑页面
     * @Param: request
     * @Param menuId
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/11
     */
    @Log(title = "菜单管理-->编辑页面", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:menu:edit")
    @GetMapping("/edit/{menuId}")
    public String edit(HttpServletRequest request, @PathVariable("menuId") String menuId, ModelMap modelMap){
        SysMenuInfo sysMenuInfo = sysMenuInfoService.getMenuInfoById(menuId);
        modelMap.put("info",sysMenuInfo);
        return SYS_MENU_PATH + "/edit";
    }

    /**
     * @Title: checkMenuNameUnique
     * @Description:  校验同级别的菜单名称是否唯一
     * @Param: sysMenuInfo
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/11
     */
    @PostMapping("/checkMenuNameUnique")
    @ResponseBody
    public String checkMenuNameUnique(SysMenuInfo sysMenuInfo){
        return sysMenuInfoService.checkMenuNameUnique(sysMenuInfo);
    }

    /**
     * @Title: saveOrUpdate
     * @Description:  保存或修改操作
     * @Param: request
     * @Param sysMenuInfo
     * @return: com.blog.sys.common.base.ResponseData
     * @author: yankai
     * @date   2019/11/11
     */
    @Log(title = "菜单管理-->保存数据", businessType = BusinessType.INSERT)
    @RequiresPermissions(value={"sys:menu:add","sys:menu:edit"},logical= Logical.OR)
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseData saveOrUpdate(HttpServletRequest request,SysMenuInfo sysMenuInfo){
        ResponseData data  = operateFailed("保存失败");
        int state = 0;
        if (StringUtils.isNotEmpty(sysMenuInfo.getMenuId())){
            sysMenuInfo.setUpdateTime(new Date());
            sysMenuInfo.setUpdateBy("暂时没有登录者");
            state = sysMenuInfoService.updateNotNull(sysMenuInfo);
        }else {
            sysMenuInfo.setMenuId(UUID.randomUUID().toString());
            sysMenuInfo.setCreateTime(new Date());
            sysMenuInfo.setCreateBy("暂时没有登录者");
            state = sysMenuInfoService.saveNotNull(sysMenuInfo);
        }
        if (state > 0){
            data = operateSucess("保存成功");
        }
        return data;
    }
    /**
     * @Title: deleteById
     * @Description:  通过主键删除菜单，有子菜单不允许删除
     * @Param: menuId
     * @return: com.blog.sys.common.base.ResponseData
     * @author: yankai
     * @date   2019/11/11
     */
    @Log(title = "菜单管理-->删除数据", businessType = BusinessType.DELETE)
    @RequiresPermissions("sys:menu:del")
    @PostMapping("/deleteById")
    @ResponseBody
    public ResponseData deleteById(String menuId){
        ResponseData data  = operateFailed("删除失败");
        int state = 0;
        List<SysMenuInfo> list = sysMenuInfoService.getChildMenuInfoById(menuId);
        if (list !=null && list.size()>0){
            data  = operateFailed("存在子菜单,不允许删除");
            return data;
        }
        state = sysMenuInfoService.deleteById(menuId);
        if (state > 0){
            data = operateSucess("删除成功");
        }
        return data;
    }


    /**
     * @Title: selectMenuTree
     * @Description:  跳转至菜单树页面
     * @Param: menuId
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/12
     */
    @GetMapping("/selectMenuTree/{menuId}")
    public String selectMenuTree(@PathVariable("menuId") String menuId,ModelMap modelMap){
        modelMap.put("info",sysMenuInfoService.getMenuInfoById(menuId));
        return SYS_MENU_PATH + "/tree";
    }

    /**
     * 加载角色菜单列表树
     */
    @GetMapping("/roleMenuTreeData")
    @ResponseBody
    public List<Ztree> roleMenuTreeData(SysRoleInfo sysRoleInfo){
        String userId = "admin";
        List<Ztree> ztrees = sysMenuInfoService.roleMenuTreeData(sysRoleInfo, userId);
        return ztrees;
    }


}
