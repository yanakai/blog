package com.blog.sys.menu.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.menu.model.SysMenuInfo;
import com.blog.sys.menu.service.ISysMenuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public TableDataInfo tableDataList(HttpServletRequest request, SysMenuInfo sysMenuInfo){
        List<SysMenuInfo> list = new ArrayList<>();
        return getDataTable(list);
    }

}
