package com.blog.sys.role.service.impl;

import com.blog.sys.role.mapper.SysRoleInfoMapper;
import com.blog.sys.role.service.ISysRoleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysRoleInfoServiceImpl implements ISysRoleInfoService {

    /**
     * 角色持久层接口
     */
    @Resource
    private SysRoleInfoMapper sysRoleInfoMapper;


}
