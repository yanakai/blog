package com.blog.sys.role.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.role.service.ISysRoleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sys/role")
public class SysRoleInfoController extends BaseController {
    private static final String SYS_ROLE_PATH = "/sys/role";

    /**
     * 角色业务层接口
     */
    @Resource
    private ISysRoleInfoService sysRoleInfoService;
}
