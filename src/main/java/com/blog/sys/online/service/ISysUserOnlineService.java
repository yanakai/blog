package com.blog.sys.online.service;

import com.blog.sys.online.model.SysUserOnline;

import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.online.service
 * @ClassName: ISysUserOnlineService
 * @Description: 用户在线业务层接口
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/26 22:10
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/26 22:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysUserOnlineService {
    /**
     * @method:  getList
     * @description: <p>获取用户在线列表数据</p>
     * @params:  sysUserOnline 用户在线对象
     * @return: java.util.List<com.blog.sys.online.model.SysUserOnline>
     * @date: 2019/11/26 22:22
     * @author: yanakai@126.com
     */
    List<SysUserOnline> getList(SysUserOnline sysUserOnline);

    /*
     * @method:  getById
     * @description: <p>主键查询对象</p>
     * @params:  sessionId 主键id
     * @return: com.blog.sys.online.model.SysUserOnline
     * @date: 2019/11/27 23:10
     * @author: yanakai@126.com
     */
    SysUserOnline getById(String sessionId);
}
