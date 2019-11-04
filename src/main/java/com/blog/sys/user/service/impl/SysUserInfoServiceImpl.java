package com.blog.sys.user.service.impl;

import com.blog.sys.user.mapper.SysUserInfoMapper;
import com.blog.sys.user.service.ISysUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.user.service.impl
 * @ClassName: SysUserInfoServiceImpl
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/4 22:28
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/4 22:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class SysUserInfoServiceImpl implements ISysUserInfoService {
    /**
     * 用户持久层接口
     */
    @Resource
    private SysUserInfoMapper sysUserInfoMapper;
}
