package com.blog.sys.user.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.user.service.ISysUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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

}
