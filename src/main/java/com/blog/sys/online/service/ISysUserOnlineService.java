package com.blog.sys.online.service;

import com.blog.sys.online.model.SysUserOnline;

import java.util.Date;
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

    /**
     * @method:  deleteOnlineById
     * @description: <p>通过主键删除对象</p>
     * @params:  sessionId
     * @return: int
     * @date: 2019/12/1 20:14
     * @author: yanakai@126.com
     */
    int deleteOnlineById(String sessionId);

    /**
     * @method:  saveOnline
     * @description: <p>保存用户在线信息</p>
     * @params:  online
     * @return: int
     * @date: 2019/12/1 20:41
     * @author: yanakai@126.com
     */
    int saveOnline(SysUserOnline online);

    /**
     * @method:  selectOnlineByExpired
     * @description: <p> 查询会话集合</p>
     * @params:  expiredDate 会话有效期
     * @return: java.util.List<com.blog.sys.online.model.SysUserOnline> 会话集合
     * @date: 2019/12/1 20:53
     * @author: yanakai@126.com
     */
    List<SysUserOnline> selectOnlineByExpired(Date expiredDate);

    /**
     * @method:  batchDeleteOnline
     * @description: <p>通过会话序号删除信息</p>
     * @params:  sessions 会话ID集合
     * @return: void
     * @date: 2019/12/1 20:58
     * @author: yanakai@126.com
     */
    void batchDeleteOnline(List<String> sessions);
}
