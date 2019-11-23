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

    /**
     * @method:  deleteByIds
     * @description: <p>批量删除信息</p>
     * @params:  ids 主键ids
     * @return: int
     * @date: 2019/11/23 16:48
     * @author: yanakai@126.com
     */
    int deleteByIds(String ids);

    /**
     * @method:  cleanLoginInfo
     * @description: <p>清空数据</p>
     * @params:
     * @return: int
     * @date: 2019/11/23 18:45
     * @author: yanakai@126.com
     */
    int cleanLoginInfo();

    /**
     * @method:  insertOperlog
     * @description: <p>添加操作日志</p>
     * @params:  operLog 操作日志对象
     * @return: int
     * @date: 2019/11/23 19:42
     * @author: yanakai@126.com
     */
    int insertOperlog(SysOperLog operLog);
}
