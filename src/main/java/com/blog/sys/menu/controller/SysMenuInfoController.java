package com.blog.sys.menu.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.menu.model.SysMenuInfo;
import com.blog.sys.menu.service.ISysMenuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @GetMapping("/edit/{menuId}")
    public String edit(HttpServletRequest request, @PathVariable("menuId") String menuId, ModelMap modelMap){
        SysMenuInfo sysMenuInfo = sysMenuInfoService.getById(menuId);
        modelMap.put("info",sysMenuInfo);
        return SYS_MENU_PATH + "/edit";
    }



}
