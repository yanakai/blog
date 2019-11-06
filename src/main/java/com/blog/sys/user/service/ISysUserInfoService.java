package com.blog.sys.user.service;

import com.blog.sys.user.model.SysUserInfo;

import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.user.service.ISysUserInfoService
 * @ClassName: ISysUserInfoService
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/4 22:27
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/4 22:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysUserInfoService {
    /**
     * @method:  getList
     * @description: <p>获取用户列表数据</p>
     * @params:  sysUserInfo
     * @return: java.util.List<com.blog.sys.user.model.SysUserInfo>
     * @date: 2019/11/6 21:29
     * @author: yanakai@126.com
     */
    List<SysUserInfo> getList(SysUserInfo sysUserInfo);
}
