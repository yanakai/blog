package com.blog.sys.role.service.impl;

import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.UserConstants;
import com.blog.sys.role.mapper.SysRoleInfoMapper;
import com.blog.sys.role.model.SysRoleInfo;
import com.blog.sys.role.service.ISysRoleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleInfoServiceImpl implements ISysRoleInfoService {

    /**
     * 角色持久层接口
     */
    @Resource
    private SysRoleInfoMapper sysRoleInfoMapper;


    @Override
    public List<SysRoleInfo> getList(SysRoleInfo sysRoleInfo) {
        return sysRoleInfoMapper.getList(sysRoleInfo);
    }

    @Override
    public SysRoleInfo getById(String roleId) {
        return sysRoleInfoMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateNotNull(SysRoleInfo sysRoleInfo) {
        return sysRoleInfoMapper.updateByPrimaryKeySelective(sysRoleInfo);
    }

    @Override
    public int saveNotNull(SysRoleInfo sysRoleInfo) {
        return sysRoleInfoMapper.insertSelective(sysRoleInfo);
    }

    @Override
    public int deleteById(String roleId) {
        return sysRoleInfoMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public String checkRoleNameUnique(SysRoleInfo sysRoleInfo) {
        String roleId = StringUtils.isNotEmpty(sysRoleInfo.getRoleId())?sysRoleInfo.getRoleId().trim():"";
        SysRoleInfo info = sysRoleInfoMapper.checkRoleNameUnique(sysRoleInfo.getRoleName());
        if(info != null && !roleId.equals(info.getRoleId())){
            return UserConstants.ROLE_NAME_NOT_UNIQUE;
        }
        return UserConstants.ROLE_NAME_UNIQUE;
    }
}
