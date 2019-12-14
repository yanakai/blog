package com.blog.api.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.api.controller
 * @ClassName: ApiController
 * @Description: 对外接口
 * @Author: yanakai@126.com
 * @CreateDate: 2019/12/14 16:51
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/12/14 16:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController()
@RequestMapping("/api")
public class ApiController extends BaseController {
    @Resource
    private ISysUserInfoService sysUserInfoService;

    @RequestMapping("/user/list")
    public TableDataInfo getList(SysUserInfo sysUserInfo){
        startPage();
        List<SysUserInfo> list = sysUserInfoService.getList(sysUserInfo);
        return getDataTable(list);
    }
}
