package com.blog.sys.menu.service.impl;

import com.blog.sys.menu.mapper.SysRoleMenuMapper;
import com.blog.sys.menu.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleMenuServiceImpl implements ISysRoleMenuService {

    /**
     * 角色菜单持久层接口
     */
    private SysRoleMenuMapper sysRoleMenuMapper;
}
