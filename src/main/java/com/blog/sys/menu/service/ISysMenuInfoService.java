package com.blog.sys.menu.service;

import com.blog.sys.menu.model.SysMenuInfo;

import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.menu.service
 * @ClassName: ISysMenuInfoService
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/10 20:55
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/10 20:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysMenuInfoService {
    /**
     * @Title: getMenuList
     * @Description:  查看所有菜单数据
     * @Param: sysMenuInfo
     * @return: java.util.List<com.blog.sys.menu.model.SysMenuInfo>
     * @author: yankai
     * @date   2019/11/11
     */
    List<SysMenuInfo> getMenuList(SysMenuInfo sysMenuInfo);
}
