package com.blog.sys.log.mapper;

import com.blog.sys.log.model.SysOperLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOperLogMapper {
    int deleteByPrimaryKey(Long operId);

    int insert(SysOperLog record);

    int insertSelective(SysOperLog record);

    SysOperLog selectByPrimaryKey(Long operId);

    int updateByPrimaryKeySelective(SysOperLog record);

    int updateByPrimaryKey(SysOperLog record);

    /**
     * @method:  getList
     * @description: <p>获取操作日志对象</p>
     * @params:  sysOperLog 操作日志对象
     * @return: java.util.List<com.blog.sys.log.model.SysOperLog>
     * @date: 2019/11/23 16:33
     * @author: yanakai@126.com
     */
    List<SysOperLog> getList(@Param("vo") SysOperLog sysOperLog);

    /**
     * @method:  deleteByIds
     * @description: <p>批量删除数据</p>
     * @params:  ids
     * @return: int
     * @date: 2019/11/23 16:51
     * @author: yanakai@126.com
     */
    int deleteByIds(String[] ids);
}