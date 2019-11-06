package com.blog.sys.user.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.user.controller
 * @ClassName: SysUserInfoController
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/4 22:29
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/4 22:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserInfoController extends BaseController {
    private static final String SYS_USER_PATH="/sys/user";

    /**
     * 用户业务层接口
     */
    @Resource
    private ISysUserInfoService sysUserInfoService;

    /**
     * @method:  pageList
     * @description: <p>跳转至用户列表页面</p>
     * @params: request
     * @return: java.lang.String
     * @date: 2019/11/6 21:26
     * @author: yanakai@126.com
     */
    @GetMapping("/list")
    public String pageList(HttpServletRequest request){
        return SYS_USER_PATH + "/list";
    }

    /**
     * @method:  tableDatalist
     * @description: <p>获取表格数据</p>
     * @params:  request
     * @Param: sysUserInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/11/6 21:26
     * @author: yanakai@126.com
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo tableDatalist(HttpServletRequest request, SysUserInfo sysUserInfo){
        //初始化分页
        startPage();
        List<SysUserInfo> list = sysUserInfoService.getList(sysUserInfo);
        return getDataTable(list);
    }





}
