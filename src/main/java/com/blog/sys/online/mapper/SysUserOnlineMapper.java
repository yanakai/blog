package com.blog.sys.online.mapper;

import com.blog.sys.online.model.SysUserOnline;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserOnlineMapper {
    int deleteByPrimaryKey(String sessionid);

    int insert(SysUserOnline record);

    int insertSelective(SysUserOnline record);

    SysUserOnline selectByPrimaryKey(String sessionid);

    int updateByPrimaryKeySelective(SysUserOnline record);

    int updateByPrimaryKey(SysUserOnline record);

    /**
     * @method:  getList
     * @description: <p>获取用户在线列表数据</p>
     * @params:  sysUserOnline 用户在线对象
     * @return: java.util.List<com.blog.sys.online.model.SysUserOnline>
     * @date: 2019/11/26 22:23
     * @author: yanakai@126.com
     */
    List<SysUserOnline> getList(@Param("vo") SysUserOnline sysUserOnline);

    /**
     * @method:  selectOnlineByExpired
     * @description: <p>查询会话集合</p>
     * @params:  lastAccessTime 过期时间
     * @return: java.util.List<com.blog.sys.online.model.SysUserOnline>
     * @date: 2019/12/1 20:55
     * @author: yanakai@126.com
     */
    List<SysUserOnline> selectOnlineByExpired(String lastAccessTime);

    /**
     * @method:  saveOnline
     * @description: <p>保存会话信息</p>
     * @params:  online 会话信息
     * @return: int
     * @date: 2019/12/1 22:29
     * @author: yanakai@126.com
     */
    int saveOnline(SysUserOnline online);
}