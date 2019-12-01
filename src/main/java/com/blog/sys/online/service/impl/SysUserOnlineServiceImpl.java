package com.blog.sys.online.service.impl;

import com.blog.sys.common.utils.DateUtils;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.online.mapper.SysUserOnlineMapper;
import com.blog.sys.online.model.SysUserOnline;
import com.blog.sys.online.service.ISysUserOnlineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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


    @Override
    public List<SysUserOnline> getList(SysUserOnline sysUserOnline) {
        return sysUserOnlineMapper.getList(sysUserOnline);
    }

    @Override
    public SysUserOnline getById(String sessionId) {
        return sysUserOnlineMapper.selectByPrimaryKey(sessionId);
    }

    @Override
    public int deleteOnlineById(String sessionId) {
        SysUserOnline userOnline = getById(sessionId);
        //判断当前账号是否在线，不为空则删除
        if (StringUtils.isNotNull(userOnline)){
           return sysUserOnlineMapper.deleteByPrimaryKey(sessionId);
        }
        return 0;
    }

    @Override
    public int saveOnline(SysUserOnline online) {
        return sysUserOnlineMapper.saveOnline(online);
    }

    @Override
    public List<SysUserOnline> selectOnlineByExpired(Date expiredDate) {
        String lastAccessTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, expiredDate);
        return sysUserOnlineMapper.selectOnlineByExpired(lastAccessTime);
    }

    /**
     * 通过会话序号删除信息
     *
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    @Override
    public void batchDeleteOnline(List<String> sessions) {
        for (String sessionId : sessions){
            SysUserOnline userOnline = getById(sessionId);
            if (StringUtils.isNotNull(userOnline)){
                sysUserOnlineMapper.deleteByPrimaryKey(sessionId);
            }
        }
    }


}
