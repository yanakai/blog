package com.blog.sys.log.service;

import com.blog.sys.log.model.SysOperLog;

import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.log.service
 * @ClassName: ISysOperLogService
 * @Description: 操作日志接口
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/23 16:23
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/23 16:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysOperLogService {
    /**
     * @method:  getList
     * @description: <p>获取日志操作列表</p>
     * @params:  sysOperLog 操作日志对象
     * @return: java.util.List<com.blog.sys.log.model.SysOperLog>
     * @date: 2019/11/23 16:32
     * @author: yanakai@126.com
     */
    List<SysOperLog> getList(SysOperLog sysOperLog);
}
