package com.blog.sys.shiro.service;

import com.blog.sys.common.exception.user.UserPasswordNotMatchException;
import com.blog.sys.common.exception.user.UserPasswordRetryLimitExceedException;
import com.blog.sys.common.utils.Constants;
import com.blog.sys.common.utils.MessageUtils;
import com.blog.sys.shiro.constant.ShiroConstants;
import com.blog.sys.user.model.SysUserInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 登录密码方法
 *
 */
@Component
public class SysPasswordService {
    @Resource
    private CacheManager cacheManager;

    private Cache<String, AtomicInteger> loginRecordCache;

    @Value(value = "${user.password.maxRetryCount}")
    private String maxRetryCount;

    @PostConstruct
    public void init(){
        loginRecordCache = cacheManager.getCache(ShiroConstants.LOGINRECORDCACHE);
    }

    public void validate(SysUserInfo user, String password)
    {
        String loginName = user.getUserName();

        AtomicInteger retryCount = loginRecordCache.get(loginName);

        if (retryCount == null){
            retryCount = new AtomicInteger(0);
            loginRecordCache.put(loginName, retryCount);
        }
        if (retryCount.incrementAndGet() > Integer.valueOf(maxRetryCount).intValue()){
            throw new UserPasswordRetryLimitExceedException(Integer.valueOf(maxRetryCount).intValue());
        }

        if (!matches(user, password)){
            loginRecordCache.put(loginName, retryCount);
            throw new UserPasswordNotMatchException();
        }
        else
        {
            clearLoginRecordCache(loginName);
        }
    }

    public boolean matches(SysUserInfo user, String newPassword)
    {
        return user.getPassword().equals(encryptPassword(user.getUserName(), newPassword, user.getSalt()));
    }

    public void clearLoginRecordCache(String username)
    {
        loginRecordCache.remove(username);
    }

    public String encryptPassword(String username, String password, String salt)
    {
        return new Md5Hash(username + password + salt).toHex().toString();
    }

    public void unlock(String loginName){
        loginRecordCache.remove(loginName);
    }

}
