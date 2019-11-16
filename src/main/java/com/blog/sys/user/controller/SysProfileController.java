package com.blog.sys.user.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.config.Global;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.file.FileUploadUtils;
import com.blog.sys.shiro.service.SysPasswordService;
import com.blog.sys.shiro.utils.ShiroUtils;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 个人信息 业务处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/sys/user/profile")
public class SysProfileController extends BaseController{
    private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);

    private static final String prefix = "/sys/user/profile";

    @Autowired
    private ISysUserInfoService sysUserInfoService;
    
    @Autowired
    private SysPasswordService passwordService;

    /**
     * 个人信息
     */
    @GetMapping()
    public String profile(ModelMap mmap){
        SysUserInfo user = ShiroUtils.getSysUser();
        mmap.put("user", user);
        return prefix + "/profile";
    }

    @GetMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(String password){
        SysUserInfo user = ShiroUtils.getSysUser();
        if (passwordService.matches(user, password)){
            return true;
        }
        return false;
    }

    @GetMapping("/resetPwd")
    public String resetPwd(ModelMap mmap){
        SysUserInfo user = ShiroUtils.getSysUser();
        mmap.put("user", sysUserInfoService.getById(user.getUserId()));
        return prefix + "/resetPwd";
    }

    @PostMapping("/resetPwd")
    @ResponseBody
    public ResponseData resetPwd(String oldPassword, String newPassword){
        SysUserInfo user = ShiroUtils.getSysUser();
        if (StringUtils.isNotEmpty(newPassword) && passwordService.matches(user, oldPassword)) {
            user.setSalt(ShiroUtils.randomSalt());
            user.setPassword(passwordService.encryptPassword(user.getUserName(), newPassword, user.getSalt()));
            if (sysUserInfoService.updateNotNull(user) > 0){
                ShiroUtils.setSysUser(sysUserInfoService.getById(user.getUserId()));
                return operateSucess();
            }
            return operateFailed("修改密码失败");
        }else{
            return operateFailed("修改密码失败，旧密码错误");
        }
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit")
    public String edit(ModelMap mmap){
        SysUserInfo user = ShiroUtils.getSysUser();
        mmap.put("user", sysUserInfoService.getById(user.getUserId()));
        return prefix + "/edit";
    }

    /**
     * 修改头像
     */
    @GetMapping("/avatar")
    public String avatar(ModelMap mmap){
        SysUserInfo user = ShiroUtils.getSysUser();
        mmap.put("user", sysUserInfoService.getById(user.getUserId()));
        return prefix + "/avatar";
    }

    /**
     * 修改用户
     */
    @PostMapping("/update")
    @ResponseBody
    public ResponseData update(SysUserInfo user){
        SysUserInfo currentUser = ShiroUtils.getSysUser();
        currentUser.setUserName(user.getUserName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhoneNumber(user.getPhoneNumber());
        currentUser.setSex(user.getSex());
        if (sysUserInfoService.updateNotNull(currentUser) > 0){
            ShiroUtils.setSysUser(sysUserInfoService.getById(currentUser.getUserId()));
            return operateSucess();
        }
        return operateFailed("修改失败");
    }

    /**
     * 保存头像
     */
    @PostMapping("/updateAvatar")
    @ResponseBody
    public ResponseData updateAvatar(@RequestParam("avatarfile") MultipartFile file){
        SysUserInfo currentUser = ShiroUtils.getSysUser();
        try{
            if (!file.isEmpty()){
                String avatar = FileUploadUtils.upload(Global.getAvatarPath(), file);
                currentUser.setImagePath(avatar);
                if (sysUserInfoService.updateNotNull(currentUser) > 0){
                    ShiroUtils.setSysUser(sysUserInfoService.getById(currentUser.getUserId()));
                    return operateSucess();
                }
            }
            return operateFailed("修改头像失败");
        }catch (Exception e){
            log.error("修改头像失败！", e);
            return operateFailed(e.getMessage());
        }
    }
}
