package com.blog.sys.log.mapper;

import com.blog.sys.log.model.SysLoginInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLoginInfoMapper {
    int deleteByPrimaryKey(Long infoId);

    int insert(SysLoginInfo record);

    int insertSelective(SysLoginInfo record);

    SysLoginInfo selectByPrimaryKey(Long infoId);

    int updateByPrimaryKeySelective(SysLoginInfo record);

    int updateByPrimaryKey(SysLoginInfo record);

    /**
     * @method:  getList
     * @description: <p>查询登录日志的列表数据</p>
     * @params:  sysLoginInfo
     * @return: java.util.List<com.blog.sys.log.model.SysLoginInfo>
     * @date: 2019/11/20 22:31
     * @author: yanakai@126.com
     */
    List<SysLoginInfo> getList(@Param("vo") SysLoginInfo sysLoginInfo);

    /**
     * @method:  deleteLoginInforById
     * @description: <p>批量删除对象信息</p>
     * @params:  ids
     * @return: int
     * @date: 2019/11/20 22:40
     * @author: yanakai@126.com
     */
    public int deleteLoginInfoByIds(String[] ids);

   /**
    * @method:  cleanLoginInfo
    * @description: <p>清空登录日志</p>
    * @params:
    * @return: int
    * @date: 2019/11/20 22:41
    * @author: yanakai@126.com
    */
    public int cleanLoginInfo();
}