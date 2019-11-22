package com.blog.sys.common.manager.factory;

import cn.hutool.core.lang.UUID;
import com.blog.sys.common.utils.AddressUtils;
import com.blog.sys.common.utils.Constants;
import com.blog.sys.common.utils.ServletUtils;
import com.blog.sys.common.utils.spring.SpringUtils;
import com.blog.sys.log.model.SysLoginInfo;
import com.blog.sys.log.service.impl.SysLoginInfoServiceImpl;
import com.blog.sys.shiro.utils.LogUtils;
import com.blog.sys.shiro.utils.ShiroUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 * 
 * @author liuhulu
 *
 */
public class AsyncFactory
{
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    /**
     * 记录登陆信息
     * 
     * @param username 用户名
     * @param status 状态
     * @param message 消息
     * @param args 列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String username, final String status, final String message, final Object... args)
    {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = ShiroUtils.getIp();
        return new TimerTask()
        {
            @Override
            public void run()
            {
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                sys_user_logger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLoginInfo loginInfo = new SysLoginInfo();
                loginInfo.setInfoId(UUID.randomUUID().toString());
                loginInfo.setLoginName(username);
                loginInfo.setIpaddr(ip);
                loginInfo.setLoginLocation(address);
                loginInfo.setBrowser(browser);
                loginInfo.setOs(os);
                loginInfo.setMsg(message);
                loginInfo.setLoginTime(new Date());
                // 日志状态
                if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)){
                    loginInfo.setStatus(Constants.SUCCESS);
                }else if (Constants.LOGIN_FAIL.equals(status)){
                    loginInfo.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(SysLoginInfoServiceImpl.class).saveLoginInfo(loginInfo);
            }
        };
    }
}
