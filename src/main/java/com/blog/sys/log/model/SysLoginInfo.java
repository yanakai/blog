package com.blog.sys.log.model;

import com.blog.sys.common.base.model.BaseEntity;

import java.util.Date;

/**
 * 系统访问记录
 */
public class SysLoginInfo extends BaseEntity {
    /**
     * 访问ID
     */
    private Long infoId;

    /**
     * 登录账号
     */
    private String loginName;

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
     * 登录状态（0成功 1失败）
     */
    private String status;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 访问时间
     */
    private Date loginTime;


    /**
     * 访问ID
     */
    public Long getInfoId() {
        return infoId;
    }

    /**
     * 访问ID
     */
    public void setInfoId(Long infoId) {
        this.infoId = infoId;
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
     * 登录状态（0成功 1失败）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 登录状态（0成功 1失败）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 提示消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 提示消息
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    /**
     * 访问时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 访问时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", infoId=").append(infoId);
        sb.append(", loginName=").append(loginName);
        sb.append(", ipaddr=").append(ipaddr);
        sb.append(", loginLocation=").append(loginLocation);
        sb.append(", browser=").append(browser);
        sb.append(", os=").append(os);
        sb.append(", status=").append(status);
        sb.append(", msg=").append(msg);
        sb.append(", loginTime=").append(loginTime);
        sb.append("]");
        return sb.toString();
    }
}