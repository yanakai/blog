package com.blog.sys.shiro.service;

import com.blog.sys.common.enums.UserStatus;
import com.blog.sys.common.exception.user.*;
import com.blog.sys.common.manager.factory.AsyncFactory;
import com.blog.sys.common.utils.*;
import com.blog.sys.shiro.constant.ShiroConstants;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 */
@Component
public class SysLoginService {
    @Resource
    private ISysUserInfoService sysUserInfoService;
    @Resource
    private SysPasswordService passwordService;

    /**
     * 登录
     */
    public SysUserInfo login(String username, String password){
        // 验证码校验
        if (!StringUtils.isEmpty(ServletUtils.getRequest().getAttribute(ShiroConstants.CURRENT_CAPTCHA))) {
            AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error"));
            throw new CaptchaException();
        }
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("not.null"));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH){
            AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"));
            throw new UserPasswordNotMatchException();
        }

        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH){
            AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"));
            throw new UserPasswordNotMatchException();
        }
        // 查询用户信息
        SysUserInfo user = sysUserInfoService.findByUserName(username);
        if (user == null && maybeMobilePhoneNumber(username)){
            user = sysUserInfoService.selectUserByPhoneNumber(username);
        }

        if (user == null && maybeEmail(username)){
            user = sysUserInfoService.selectUserByEmail(username);
        }
        if (user == null){
            throw new UserNotExistsException();
        }
        if (UserStatus.DELETED.getCode().equals(user.getStatus())){
            throw new UserDeleteException();
        }

        if (UserStatus.DISABLE.getCode().equals(user.getStatus())){
            throw new UserBlockedException();
        }
        passwordService.validate(user, password);
        return user;
    }

    private boolean maybeEmail(String username){
        if (!username.matches(UserConstants.EMAIL_PATTERN)){
            return false;
        }
        return true;
    }

    private boolean maybeMobilePhoneNumber(String username){
        if (!username.matches(UserConstants.MOBILE_PHONE_NUMBER_PATTERN)){
            return false;
        }
        return true;
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(SysUserInfo user){
        user.setLoginTime(DateUtils.getNowDate());
        user.setModifyTime(DateUtils.getNowDate());
        sysUserInfoService.updateNotNull(user);
    }



}
