package com.blog.sys.online.model;

import com.blog.sys.common.base.model.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 在线用户记录
 */
public class SysUserOnline extends BaseEntity {
    /**
     * 用户会话id
     */
    private String sessionId;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 在线状态on_line在线off_line离线
     */
    private String status;

    /**
     * session创建时间
     */
    private Date startTimestamp;

    /**
     * session最后访问时间
     */
    private Date lastAccessTime;

    /**
     * 超时时间，单位为分钟
     */
    private Long expireTime;


    /**
     * 用户会话id
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 用户会话id
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    /**
     * 登录账号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录账号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * 登录IP地址
     */
    public String getIpaddr() {
        return ipaddr;
    }

    /**
     * 登录IP地址
     */
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    /**
     * 登录地点
     */
    public String getLoginLocation() {
        return loginLocation;
    }

    /**
     * 登录地点
     */
    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation == null ? null : loginLocation.trim();
    }

    /**
     * 浏览器类型
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * 浏览器类型
     */
    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }

    /**
     * 操作系统
     */
    public String getOs() {
        return os;
    }

    /**
     * 操作系统
     */
    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    /**
     * 在线状态on_line在线off_line离线
     */
    public String getStatus() {
        return status;
    }

    /**
     * 在线状态on_line在线off_line离线
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * session创建时间
     */
    public Date getStartTimestamp() {
        return startTimestamp;
    }

    /**
     * session创建时间
     */
    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    /**
     * session最后访问时间
     */
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * session最后访问时间
     */
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    /**
     * 超时时间，单位为分钟
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * 超时时间，单位为分钟
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sessionId=").append(sessionId);
        sb.append(", loginName=").append(loginName);
        sb.append(", deptName=").append(deptName);
        sb.append(", ipaddr=").append(ipaddr);
        sb.append(", loginLocation=").append(loginLocation);
        sb.append(", browser=").append(browser);
        sb.append(", os=").append(os);
        sb.append(", status=").append(status);
        sb.append(", startTimestamp=").append(startTimestamp);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", expireTime=").append(expireTime);
        sb.append("]");
        return sb.toString();
    }
}