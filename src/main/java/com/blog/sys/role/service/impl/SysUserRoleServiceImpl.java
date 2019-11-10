package com.blog.sys.role.service.impl;

import com.blog.sys.role.mapper.SysUserRoleMapper;
import com.blog.sys.role.model.SysUserRole;
import com.blog.sys.role.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.role.service.impl
 * @ClassName: SysUserRoleServiceImpl
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/9 17:22
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/9 17:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int deleteUserRoleInfo(SysUserRole sysUserRole) {
        return sysUserRoleMapper.deleteUserRoleInfo(sysUserRole);
    }
}
