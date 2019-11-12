package com.blog.sys.menu.service.impl;

import com.blog.sys.common.base.model.Ztree;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.UserConstants;
import com.blog.sys.menu.mapper.SysMenuInfoMapper;
import com.blog.sys.menu.model.SysMenuInfo;
import com.blog.sys.menu.service.ISysMenuInfoService;
import com.blog.sys.role.model.SysRoleInfo;
import com.blog.sys.user.model.SysUserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.menu.service.impl
 * @ClassName: SysMenuInfoServiceImpl
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/10 20:55
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/10 20:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class SysMenuInfoServiceImpl implements ISysMenuInfoService {
    /**
     * 菜单持久层接口
     */
    @Resource
    private SysMenuInfoMapper sysMenuInfoMapper;


    @Override
    public List<SysMenuInfo> getMenuList(SysMenuInfo sysMenuInfo) {
        return sysMenuInfoMapper.getMenuList(sysMenuInfo);
    }

    @Override
    public SysMenuInfo getById(String menuId) {
        return sysMenuInfoMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int getMaxSortByParentId(String parentId) {
        return sysMenuInfoMapper.getMaxSortByParentId(parentId);
    }

    @Override
    public int updateNotNull(SysMenuInfo sysMenuInfo) {
        return sysMenuInfoMapper.updateByPrimaryKeySelective(sysMenuInfo);
    }

    @Override
    public int saveNotNull(SysMenuInfo sysMenuInfo) {
        return sysMenuInfoMapper.insertSelective(sysMenuInfo);
    }

    @Override
    public int deleteById(String menuId) {
        return sysMenuInfoMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public String checkMenuNameUnique(SysMenuInfo sysMenuInfo) {
        String menuId = StringUtils.isNotEmpty(sysMenuInfo.getMenuId())?sysMenuInfo.getMenuId() : "";
        SysMenuInfo info = sysMenuInfoMapper.checkMenuNameUnique(sysMenuInfo.getParentId(),sysMenuInfo.getMenuName());
        if (StringUtils.isNotNull(info) && !menuId.equals(info.getMenuId())){
            return UserConstants.MENU_NAME_NOT_UNIQUE;
        }
        return UserConstants.MENU_NAME_UNIQUE;
    }

    @Override
    public SysMenuInfo getMenuInfoById(String menuId) {
        return sysMenuInfoMapper.getMenuInfoById(menuId);
    }

    @Override
    public List<SysMenuInfo> getChildMenuInfoById(String menuId) {
        return sysMenuInfoMapper.getChildMenuInfoById(menuId);
    }

    @Override
    public List<Ztree> roleMenuTreeData(SysRoleInfo sysRoleInfo, String userId) {
        String  roleId = sysRoleInfo.getRoleId();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<SysMenuInfo> menuList = selectMenuAll(userId);
        if (StringUtils.isNotNull(roleId)){
            List<String> roleMenuList = sysMenuInfoMapper.selectMenuTree(roleId);
            ztrees = initZtree(menuList, roleMenuList, true);
        }else{
            ztrees = initZtree(menuList, null, true);
        }
        return ztrees;
    }

    @Override
    public Set<String> getMenuPermsByUserId(String userId) {
        List<String> params=sysMenuInfoMapper.getMenuParamsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for(String perm : params){
            if (StringUtils.isNotEmpty(perm)){
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * @Title: initZtree
     * @Description:  初始化ztree数据 对象转ztree结构
     * @Param: menuList 菜单列表
     * @Param roleMenuList 角色已存在菜单列表
     * @Param permsFlag
     * @return: java.util.List<com.blog.sys.common.base.model.Ztree> 树结构列表
     * @author: yankai
     * @date   2019/11/12
     */
    public List<Ztree> initZtree(List<SysMenuInfo> menuList, List<String> roleMenuList, boolean permsFlag) {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleMenuList);
        for (SysMenuInfo sysMenuInfo : menuList){
            Ztree ztree = new Ztree();
            ztree.setId(sysMenuInfo.getMenuId());
            ztree.setpId(sysMenuInfo.getParentId());
            ztree.setName(transMenuName(sysMenuInfo, permsFlag));
            ztree.setTitle(sysMenuInfo.getMenuName());
            if (isCheck){
                ztree.setChecked(roleMenuList.contains(sysMenuInfo.getMenuId() + sysMenuInfo.getPerms()));
            }
            ztrees.add(ztree);
        }
        return ztrees;
    }

    public String transMenuName(SysMenuInfo sysMenuInfo, boolean permsFlag) {
        StringBuffer sb = new StringBuffer();
        sb.append(sysMenuInfo.getMenuName());
        if (permsFlag){
            sb.append("<font color=\"#888\">&nbsp;&nbsp;&nbsp;" + sysMenuInfo.getPerms() + "</font>");
        }
        return sb.toString();
    }

    /**
     * @Title: selectMenuAll
     * @Description: 通过用户id获取用户所拥有的菜单权限数据
     * @Param: userId 用户id
     * @return: java.util.List<com.blog.sys.menu.model.SysMenuInfo>
     * @author: yankai
     * @date   2019/11/12
     */
    public List<SysMenuInfo> selectMenuAll(String userId) {
        List<SysMenuInfo> menuList = new ArrayList<>();
        if (SysUserInfo.isAdmin(userId)){
            menuList = sysMenuInfoMapper.selectMenuAll();
        }else{
            menuList = sysMenuInfoMapper.selectMenuAllByUserId(userId);
        }
        return menuList;
    }

}
