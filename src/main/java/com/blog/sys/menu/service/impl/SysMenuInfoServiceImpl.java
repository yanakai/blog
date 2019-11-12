package com.blog.sys.menu.service.impl;

import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.UserConstants;
import com.blog.sys.menu.mapper.SysMenuInfoMapper;
import com.blog.sys.menu.model.SysMenuInfo;
import com.blog.sys.menu.service.ISysMenuInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
