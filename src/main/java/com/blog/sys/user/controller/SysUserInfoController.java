package com.blog.sys.user.controller;

import cn.hutool.core.lang.UUID;
import com.blog.sys.common.annotation.Log;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.enums.BusinessType;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.UserConstants;
import com.blog.sys.role.model.SysRoleInfo;
import com.blog.sys.role.service.ISysRoleInfoService;
import com.blog.sys.shiro.service.SysPasswordService;
import com.blog.sys.shiro.utils.ShiroUtils;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.user.controller
 * @ClassName: SysUserInfoController
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/4 22:29
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/4 22:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserInfoController extends BaseController {
    private static final String SYS_USER_PATH="/sys/user";

    /**
     * 用户业务层接口
     */
    @Resource
    private ISysUserInfoService sysUserInfoService;
    /**
     * 角色业务层接口
     */
    @Resource
    private ISysRoleInfoService sysRoleInfoService;

    @Autowired
    private SysPasswordService passwordService;

    /**
     * @method:  pageList
     * @description: <p>跳转至用户列表页面</p>
     * @params: request
     * @return: java.lang.String
     * @date: 2019/11/6 21:26
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:user:view")
    @GetMapping("/list")
    public String pageList(HttpServletRequest request){
        return SYS_USER_PATH + "/list";
    }

    /**
     * @method:  tableDatalist
     * @description: <p>获取表格数据</p>
     * @params:  request
     * @Param: sysUserInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/11/6 21:26
     * @author: yanakai@126.com
     */
    @Log(title = "用户管理-->用户列表", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo tableDataList(HttpServletRequest request, SysUserInfo sysUserInfo){
        //初始化分页
        startPage();
        List<SysUserInfo> list = sysUserInfoService.getList(sysUserInfo);
        return getDataTable(list);
    }

    /**
     * @method:  add
     * @description: <p>跳转至用户添加页面</p>
     * @params:  request
     * @Param modelMap
     * @return: java.lang.String
     * @date: 2019/11/7 21:30
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->添加页面", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:user:add")
    @GetMapping("/add")
    public String add(HttpServletRequest request, ModelMap modelMap){
        //获取所有的角色
        SysRoleInfo sysRoleInfo = new SysRoleInfo();
        List<SysRoleInfo> roleInfos = sysRoleInfoService.getList(sysRoleInfo);
        modelMap.put("roles",roleInfos);
        return SYS_USER_PATH+"/add";
    }

    /**
     * @method:  edit
     * @description: <p>跳转至用户编辑页面</p>
     * @params:  request
     * @Param userId 用户id
     * @Param modelMap
     * @return: java.lang.String
     * @date: 2019/11/7 21:33
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->编辑页面", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:user:edit")
    @GetMapping("/edit/{userId}")
    public String edit(HttpServletRequest request, @PathVariable("userId") String userId, ModelMap modelMap){
        modelMap.put("info",sysUserInfoService.getById(userId));
        //在service层使用动态代理调用执行方法获取数据 具体可以在方法实现类内查看
        modelMap.put("roles",sysRoleInfoService.getRoleListByUserId(userId));
        return SYS_USER_PATH + "/edit";
    }

    /**
     * @method:  saveOrUpdate
     * @description: <p>保存或修改</p>
     * @params:  request
     * @Param sysUserInfo 用户对象
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/7 21:45
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->保存数据", businessType = BusinessType.INSERT)
    @RequiresPermissions(value={"sys:user:add","sys:user:edit"},logical = Logical.OR)
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseData saveOrUpdate(HttpServletRequest request,SysUserInfo sysUserInfo){
        ResponseData data = operateFailed("保存失败");
        int state = 0;
        if (StringUtils.isNotEmpty(sysUserInfo.getUserId())){
            if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(sysUserInfoService.checkPhoneUnique(sysUserInfo))){
                data.setMsg("保存用户'" + sysUserInfo.getUserName() + "'失败，手机号码已存在");
                return data;
            }else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(sysUserInfoService.checkEmailUnique(sysUserInfo))){
                data.setMsg("保存用户'" + sysUserInfo.getUserName() + "'失败，邮箱账号已存在");
                return data;
            }
            sysUserInfo.setModifyTime(new Date());
            state = sysUserInfoService.updateNotNull(sysUserInfo);
        }else {
            if (UserConstants.USER_NAME_NOT_UNIQUE.equals(sysUserInfoService.checkUserNameUnique(sysUserInfo))) {
                data.setMsg("保存用户'" + sysUserInfo.getUserName() + "'失败，登录账号已存在");
                return data;
            }else if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(sysUserInfoService.checkPhoneUnique(sysUserInfo))){
                data.setMsg("保存用户'" + sysUserInfo.getUserName() + "'失败，手机号码已存在");
                return data;
            }else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(sysUserInfoService.checkEmailUnique(sysUserInfo))){
                data.setMsg("保存用户'" + sysUserInfo.getUserName() + "'失败，邮箱账号已存在");
                return data;
            }
            //生成用户盐
            sysUserInfo.setSalt(ShiroUtils.randomSalt());
            sysUserInfo.setUserId(UUID.randomUUID().toString());
            sysUserInfo.setPassword(passwordService.encryptPassword(sysUserInfo.getUserName(), sysUserInfo.getPassword(), sysUserInfo.getSalt()));
            sysUserInfo.setCreateTime(new Date());
            state = sysUserInfoService.saveNotNull(sysUserInfo);
        }
        if (state>0){
            data = operateSucess("保存成功");
        }
        return data;
    }

    /**
     * @method:  deleteById
     * @description: <p>通过主键删除对象</p>
     * @params:  request
     * @Param userId
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/7 21:51
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->删除角色", businessType = BusinessType.DELETE)
    @RequiresPermissions("sys:user:del")
    @PostMapping("/deleteById")
    @ResponseBody
    public ResponseData deleteById(HttpServletRequest request,String userId){
        ResponseData data = operateFailed("删除失败");
        int state = 0;
        if (StringUtils.isNotEmpty(userId)){
            state = sysUserInfoService.deleteById(userId);
        }
        if (state>0){
            data = operateSucess("删除成功");
        }
        return data;
    }

    /**
     * @method:  checkUserNameUnique
     * @description: <p>验证用户名是否已存在</p>
     * @params:  request
     * @Param sysUserInfo
     * @return: java.lang.String
     * @date: 2019/11/8 21:41
     * @author: yanakai@126.com
     */
    @PostMapping("/checkUserNameUnique")
    @ResponseBody
    public String checkUserNameUnique(HttpServletRequest request,SysUserInfo sysUserInfo){
        return sysUserInfoService.checkUserNameUnique(sysUserInfo);
    }

    /**
     * @method:  checkPhoneUnique
     * @description: <p>验证手机号是否已存在</p>
     * @params:  request
     * @Param sysUserInfo
     * @return: java.lang.String
     * @date: 2019/11/8 21:41
     * @author: yanakai@126.com
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(HttpServletRequest request,SysUserInfo sysUserInfo){
        return sysUserInfoService.checkPhoneUnique(sysUserInfo);
    }

    /**
     * @method:  checkEmailUnique
     * @description: <p>验证email是否已存在</p>
     * @params:  request
     * @Param sysUserInfo
     * @return: java.lang.String
     * @date: 2019/11/8 21:42
     * @author: yanakai@126.com
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(HttpServletRequest request,SysUserInfo sysUserInfo){
        return sysUserInfoService.checkEmailUnique(sysUserInfo);
    }

    /**
     * @method:  changeStatus
     * @description: <p>用户禁用、启用操作</p>
     * @params:  sysUserInfo
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/8 21:43
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->用户启用/禁用", businessType = BusinessType.UPDATE)
    @RequiresPermissions("sys:user:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public ResponseData changeStatus(SysUserInfo sysUserInfo){
        ResponseData data = operateFailed("操作失败");
        sysUserInfo.setModifyTime(new Date());
        int state=sysUserInfoService.updateNotNull(sysUserInfo);
        if(state>0) {
            data=operateSucess("操作成功");
        }
        return data;
    }

    /**
     * @method:  resetPwd
     * @description: <p>跳转至密码重置页面</p>
     * @params:  userId 用户id
     * @Param model
     * @return: java.lang.String
     * @date: 2019/11/8 21:46
     * @author: yanakai@126.com
     */
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId")String userId, Model model) {
        SysUserInfo sysUserInfo=sysUserInfoService.getById(userId);
        model.addAttribute("info", sysUserInfo);
        return SYS_USER_PATH+"/resetPwd";
    }

    /**
     * @method:  resetPwdSave
     * @description: <p>保存重置的密码</p>
     * @params:  sysUserInfo
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/8 21:48
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->修改密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public ResponseData resetPwdSave(SysUserInfo sysUserInfo) {
        ResponseData data=operateFailed("操作失败");
        sysUserInfo.setModifyTime(new Date());
        sysUserInfo.setSalt(ShiroUtils.randomSalt());
        sysUserInfo.setPassword(passwordService.encryptPassword(sysUserInfo.getUserName(), sysUserInfo.getPassword(), sysUserInfo.getSalt()));
        int state = sysUserInfoService.updateNotNull(sysUserInfo);
        if (state>0) {
            if (ShiroUtils.getUserId() == sysUserInfo.getUserId()){
                ShiroUtils.setSysUser(sysUserInfoService.getById(sysUserInfo.getUserId()));
            }
            data=operateSucess("操作成功");
        }
        return data;
    }


}
