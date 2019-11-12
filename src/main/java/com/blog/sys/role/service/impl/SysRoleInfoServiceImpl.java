package com.blog.sys.role.service.impl;

import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.UserConstants;
import com.blog.sys.menu.mapper.SysRoleMenuMapper;
import com.blog.sys.menu.model.SysRoleMenu;
import com.blog.sys.role.mapper.SysRoleInfoMapper;
import com.blog.sys.role.model.SysRoleInfo;
import com.blog.sys.role.service.ISysRoleInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleInfoServiceImpl implements ISysRoleInfoService {

    /**
     * 角色持久层接口
     */
    @Resource
    private SysRoleInfoMapper sysRoleInfoMapper;

    /**
     * 角色菜单持久层接口
     */
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;


    @Override
    public List<SysRoleInfo> getList(SysRoleInfo sysRoleInfo) {
        return sysRoleInfoMapper.getList(sysRoleInfo);
    }

    @Override
    public SysRoleInfo getById(String roleId) {
        return sysRoleInfoMapper.selectByPrimaryKey(roleId);
    }

    @Override
    @Transactional
    public int updateNotNull(SysRoleInfo sysRoleInfo) {
        //修改角色信息
        sysRoleInfoMapper.updateByPrimaryKeySelective(sysRoleInfo);
        // 删除角色与菜单关联
        sysRoleMenuMapper.deleteRoleMenuByRoleId(sysRoleInfo.getRoleId());
        return saveRoleMenu(sysRoleInfo);
    }

    @Override
    @Transactional
    public int saveNotNull(SysRoleInfo sysRoleInfo) {
        sysRoleInfoMapper.insertSelective(sysRoleInfo);
        return saveRoleMenu(sysRoleInfo);
    }

    /**
     * @Title: 返回角色信息
     * @Description:  
     * @Param: sysRoleInfo 
     * @return: int
     * @author: yankai
     * @date   2019/11/12 
     */ 
    public int saveRoleMenu(SysRoleInfo sysRoleInfo) {
        int rows = 1;
        // 新增用户与角色管理
        List<SysRoleMenu> list = new ArrayList<SysRoleMenu>();
        for (String menuId : sysRoleInfo.getMenuIds()){
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleId(sysRoleInfo.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0){
            rows = sysRoleMenuMapper.insertRoleMenu(list);
        }
        return rows;
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

    @Override
    public String checkRoleKeyUnique(SysRoleInfo sysRoleInfo) {
        String roleId = StringUtils.isNotEmpty(sysRoleInfo.getRoleId())?sysRoleInfo.getRoleId().trim():"";
        SysRoleInfo info = sysRoleInfoMapper.checkRoleKeyUnique(sysRoleInfo.getRoleKey());
        if(info != null && !roleId.equals(info.getRoleId())){
            return UserConstants.ROLE_KEY_NOT_UNIQUE;
        }
        return UserConstants.ROLE_KEY_UNIQUE;
    }

    @Override
    public int getMaxSort() {
        return sysRoleInfoMapper.getMaxSort();
    }
}
