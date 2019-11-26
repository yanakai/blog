package com.blog.sys.online.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.online.model.SysUserOnline;
import com.blog.sys.online.service.ISysUserOnlineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.online.controller
 * @ClassName: SysUserOnlineController
 * @Description: 用户在线业务层
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/26 22:13
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/26 22:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sys/userOnline")
public class SysUserOnlineController extends BaseController {

    private static final String SYS_ONLINE_PATH = "/sys/online";
    /**
     * 用户在线业务成接口
     */
    @Resource
    private ISysUserOnlineService sysUserOnlineService;

    /**
     * @method:  pageList
     * @description: <p>跳转至用户在线列表页面</p>
     * @params:
     * @return: java.lang.String
     * @date: 2019/11/26 22:19
     * @author: yanakai@126.com
     */
    @GetMapping("/list")
    public String pageList(ModelMap modelMap){
        return SYS_ONLINE_PATH + "/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo tableDataInfo(SysUserOnline sysUserOnline){
        startPage();
        List<SysUserOnline> list = sysUserOnlineService.getList(sysUserOnline);
        return getDataTable(list);
    }

}
