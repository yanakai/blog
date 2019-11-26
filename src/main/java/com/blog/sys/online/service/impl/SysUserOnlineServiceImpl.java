package com.blog.sys.online.service.impl;

import com.blog.sys.online.mapper.SysUserOnlineMapper;
import com.blog.sys.online.service.ISysUserOnlineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.online.service.impl
 * @ClassName: SysUserOnlineServiceImpl
 * @Description: 用户在线实现类
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/26 22:11
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/26 22:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class SysUserOnlineServiceImpl implements ISysUserOnlineService {

    /**
     * 用户在线持久层接口
     */
    @Resource
    private SysUserOnlineMapper sysUserOnlineMapper;
}
