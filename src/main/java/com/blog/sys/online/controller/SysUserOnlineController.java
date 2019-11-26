package com.blog.sys.online.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.online.service.ISysUserOnlineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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

    @Resource
    private ISysUserOnlineService sysUserOnlineService;
}
