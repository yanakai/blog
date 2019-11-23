package com.blog.sys.log.service.impl;

import com.blog.sys.log.mapper.SysOperLogMapper;
import com.blog.sys.log.model.SysOperLog;
import com.blog.sys.log.service.ISysOperLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.log.service.impl
 * @ClassName: SysOperLogServiceImpl
 * @Description: 操作日志接口实现类
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/23 16:23
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/23 16:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class SysOperLogServiceImpl implements ISysOperLogService {

    /**
     *  操作日志持久层
     */
    @Resource
    private SysOperLogMapper sysOperLogMapper;

    @Override
    public List<SysOperLog> getList(SysOperLog sysOperLog) {
        return sysOperLogMapper.getList(sysOperLog);
    }
}
