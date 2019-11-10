package com.blog.sys.user.service.impl;

import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.UserConstants;
import com.blog.sys.user.mapper.SysUserInfoMapper;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<SysUserInfo> getList(SysUserInfo sysUserInfo) {
        return sysUserInfoMapper.getList(sysUserInfo);
    }

    @Override
    public SysUserInfo getById(String userId) {
        return sysUserInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateNotNull(SysUserInfo sysUserInfo) {
        return sysUserInfoMapper.updateByPrimaryKeySelective(sysUserInfo);
    }

    @Override
    public int saveNotNull(SysUserInfo sysUserInfo) {
        return sysUserInfoMapper.insertSelective(sysUserInfo);
    }

    @Override
    public int deleteById(String userId) {
        return sysUserInfoMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public String checkUserNameUnique(SysUserInfo sysUserInfo) {
        //用户名是不允许修改的，所以此判断只有在添加的时候生效故只需验证用户名数量
        int count = sysUserInfoMapper.checkUserNameUnique(sysUserInfo.getUserName());
        if (count>0){
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    @Override
    public String checkPhoneUnique(SysUserInfo sysUserInfo) {
        String userId = StringUtils.isNull(sysUserInfo.getUserId()) ? "":sysUserInfo.getUserId();
        SysUserInfo info = sysUserInfoMapper.checkPhoneUnique(sysUserInfo.getPhoneNumber());
        if (StringUtils.isNotNull(info) && !userId.equals(info.getUserId())){
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    @Override
    public String checkEmailUnique(SysUserInfo sysUserInfo) {
        String userId = StringUtils.isNull(sysUserInfo.getUserId()) ?"":sysUserInfo.getUserId();
        SysUserInfo info = sysUserInfoMapper.checkEmailUnique(sysUserInfo.getEmail());
        if (StringUtils.isNotNull(info) && !userId.equals(info.getUserId())){
            return UserConstants.USER_EMAIL_NOT_UNIQUE;
        }
        return UserConstants.USER_EMAIL_UNIQUE;
    }

    @Override
    public List<SysUserInfo> allocatedList(SysUserInfo sysUserInfo) {
        return sysUserInfoMapper.allocatedList(sysUserInfo);
    }
}
