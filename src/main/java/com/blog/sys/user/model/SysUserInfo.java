package com.blog.sys.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class SysUserInfo implements Serializable {
    /**
     * 
     */
    private String userId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 登录名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String trueName;

    /**
     * 性别 0：男；1：女 默认0
     */
    private String sex;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * salt码
     */
    private String salt;

    /**
     * 状态
     */
    private String status;

    /**
     * 图片路径
     */
    private String imagePath;

    /**
     * 图片名称
     */
    private String imageName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 登录名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 登录名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 真实姓名
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 真实姓名
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    /**
     * 性别 0：男；1：女 默认0
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别 0：男；1：女 默认0
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim()  ;
    }

    /**
     * salt码
     */
    public String getSalt() {
        return salt;
    }

    /**
     * salt码
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 图片路径
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 图片路径
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    /**
     * 图片名称
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * 图片名称
     */
    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 最后登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", email=").append(email);
        sb.append(", userName=").append(userName);
        sb.append(", trueName=").append(trueName);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", status=").append(status);
        sb.append(", imagePath=").append(imagePath);
        sb.append(", imageName=").append(imageName);
        sb.append(", createTime=").append(createTime);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}