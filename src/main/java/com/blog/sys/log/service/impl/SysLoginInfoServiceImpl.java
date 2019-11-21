package com.blog.sys.log.service.impl;

import com.blog.sys.log.mapper.SysLoginInfoMapper;
import com.blog.sys.log.model.SysLoginInfo;
import com.blog.sys.log.service.ISysLoginInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.log.service.impl
 * @ClassName: SysLoginInfoServiceImpl
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/20 22:11
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/20 22:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class SysLoginInfoServiceImpl implements ISysLoginInfoService {
    /**
     * 登录日志持久层接口
     */
    @Resource
    private SysLoginInfoMapper sysLoginInfoMapper;

    @Override
    public List<SysLoginInfo> getList(SysLoginInfo sysLoginInfo) {
        return sysLoginInfoMapper.getList(sysLoginInfo);
    }

    @Override
    public int cleanLoginInfo() {
        return sysLoginInfoMapper.cleanLoginInfo();
    }

    public int saveLoginInfo(SysLoginInfo loginInfo) {
        return sysLoginInfoMapper.insertSelective(loginInfo);
    }
}
