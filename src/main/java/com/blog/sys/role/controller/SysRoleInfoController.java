package com.blog.sys.role.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.blog.sys.common.annotation.Log;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.enums.BusinessType;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.UserConstants;
import com.blog.sys.menu.service.ISysMenuInfoService;
import com.blog.sys.role.model.SysRoleInfo;
import com.blog.sys.role.model.SysUserRole;
import com.blog.sys.role.service.ISysRoleInfoService;
import com.blog.sys.role.service.ISysUserRoleService;
import com.blog.sys.shiro.utils.ShiroUtils;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sys/role")
public class SysRoleInfoController extends BaseController {
    private static final String SYS_ROLE_PATH = "/sys/role";

    /**
     * 角色业务层接口
     */
    @Resource
    private ISysRoleInfoService sysRoleInfoService;

    /**
     * 用户业务层接口
     */
    @Resource
    private ISysUserInfoService sysUserInfoService;

    /**
     * 用户角色业务层接口
     */
    @Resource
    private ISysUserRoleService sysUserRoleService;
    /**
     * 菜单信息业务层接口
     */
    @Resource
    private ISysMenuInfoService sysMenuInfoService;

    /**
     * @Title: pageList
     * @Description:  跳转至角色列表页面
     * @Param: request
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/8
     */
    @RequiresPermissions("sys:role:view")
    @GetMapping("/list")
    public String pageList(HttpServletRequest request, ModelMap modelMap){
        return SYS_ROLE_PATH + "/list";
    }

    /**
     * @Title: tableDataList
     * @Description:  获取角色列表数据
     * @Param: request
     * @Param sysRoleInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @author: yankai
     * @date   2019/11/8
     */
    @Log(title = "角色管理-->列表页面", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:role:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo tableDataList(HttpServletRequest request, SysRoleInfo sysRoleInfo){
        //执行分页
        startPage();
        List<SysRoleInfo> list = sysRoleInfoService.getList(sysRoleInfo);
        return getDataTable(list);
    }

    /**
     * @Title: add
     * @Description:  跳转至角色添加页面
     * @Param: request
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/8
     */
    @Log(title = "角色管理-->添加页面", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:role:add")
    @GetMapping("/add")
    public String add(HttpServletRequest request,ModelMap modelMap){
        //获取最大的排序码
        int roleSort = sysRoleInfoService.getMaxSort();
        modelMap.put("roleSort",roleSort);
        return SYS_ROLE_PATH + "/add";
    }
    /**
     * @Title: edit
     * @Description:  跳转至角色编辑页面
     * @Param: request
     * @Param roleId 角色id
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/8
     */
    @Log(title = "角色管理-->编辑页面", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:role:edit")
    @GetMapping("/edit/{roleId}")
    public String edit(HttpServletRequest request, @PathVariable("roleId") String roleId,ModelMap modelMap){
        if (StrUtil.isNotEmpty(roleId)){
            SysRoleInfo info = sysRoleInfoService.getById(roleId);
            modelMap.put("info",info);
        }
        return SYS_ROLE_PATH + "/edit";
    }

    /**
     * @Title: saveOrUpdate
     * @Description:  保存数据
     * @Param: request
     * @Param sysRoleInfo
     * @return: com.blog.sys.common.base.ResponseData
     * @author: yankai
     * @date   2019/11/8
     */
    @Log(title = "角色管理-->保存数据", businessType = BusinessType.INSERT)
    @RequiresPermissions(value={"sys:column:add","sys:column:edit"},logical= Logical.OR)
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseData saveOrUpdate(HttpServletRequest request, SysRoleInfo sysRoleInfo){
        ResponseData data = operateFailed("保存失败");
        int state = 0;
        if (UserConstants.ROLE_NAME_NOT_UNIQUE.equals(sysRoleInfoService.checkRoleNameUnique(sysRoleInfo))){
            data.setMsg("保存角色'" + sysRoleInfo.getRoleName() + "'失败，角色名称已存在");
            return data;
        }
        if (UserConstants.ROLE_KEY_NOT_UNIQUE.equals(sysRoleInfoService.checkRoleKeyUnique(sysRoleInfo))){
            data.setMsg("保存角色'" + sysRoleInfo.getRoleName() + "'失败，角色key已存在");
            return data;
        }
        //清除权限缓存
        ShiroUtils.clearCachedAuthorizationInfo();
        if (StringUtils.isNotEmpty(sysRoleInfo.getRoleId())){
            sysRoleInfo.setUpdateTime(new Date());
            sysRoleInfo.setUpdateBy("暂无登录者");
            state = sysRoleInfoService.updateNotNull(sysRoleInfo);
        }else {
            sysRoleInfo.setRoleId(UUID.randomUUID().toString());
            sysRoleInfo.setCreateTime(new Date());
            sysRoleInfo.setCreateBy("暂无登录者");
            state = sysRoleInfoService.saveNotNull(sysRoleInfo);
        }
        if (state>0){
            data = operateSucess("保存成功");
        }
        return data;
    }

    /**
     * @method:  deleteById
     * @description: <p>通过主键删除对象信息</p>
     * @params:  request
     * @Param roleId
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/8 23:07
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->删除数据", businessType = BusinessType.DELETE)
    @RequiresPermissions("sys:role:del")
    @PostMapping("/deleteById")
    @ResponseBody
    public ResponseData deleteById(HttpServletRequest request,String roleId){
        ResponseData data = operateFailed("删除失败");
        int state = 0;
        if (StringUtils.isNotEmpty(roleId)){
            state = sysRoleInfoService.deleteById(roleId);
        }
        if (state>0){
            data = operateSucess("删除成功");
        }
        return data;
    }

    /**
     * @method:  checkRoleNameUnique
     * @description: <p>验证角色名称是否唯一</p>
     * @params:  request
     * @Param sysRoleInfo
     * @return: java.lang.String
     * @date: 2019/11/8 23:03
     * @author: yanakai@126.com
     */
    @PostMapping("/checkRoleNameUnique")
    @ResponseBody
    public String checkRoleNameUnique(HttpServletRequest request,SysRoleInfo sysRoleInfo){
     return sysRoleInfoService.checkRoleNameUnique(sysRoleInfo);
    }

    /**
     * @method:  checkRoleKeyUnique
     * @description: <p>验证角色key是否唯一</p>
     * @params:  request
     * @Param sysRoleInfo
     * @return: java.lang.String
     * @date: 2019/11/9 15:18
     * @author: yanakai@126.com
     */
    @PostMapping("/checkRoleKeyUnique")
    @ResponseBody
    public String checkRoleKeyUnique(HttpServletRequest request,SysRoleInfo sysRoleInfo){
        return sysRoleInfoService.checkRoleKeyUnique(sysRoleInfo);
    }

    /**
     * @method:  changeStatus
     * @description: <p>启用、禁用角色</p>
     * @params:  request
     * @Param sysRoleInfo
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/8 23:05
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->角色禁用/启用", businessType = BusinessType.UPDATE)
    @RequiresPermissions("sys:user:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public ResponseData changeStatus(HttpServletRequest request,SysRoleInfo sysRoleInfo){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        sysRoleInfo.setUpdateTime(new Date());
        sysRoleInfo.setUpdateBy("暂无登录者");
        state = sysRoleInfoService.changeStatus(sysRoleInfo);
        if (state>0){
            data = operateSucess("操作成功");
        }
        return data;
    }

    /**
     * @method:  authUser
     * @description: <p>跳转至角色下用户列表页</p>
     * @params:  request
     * @Param roleId 角色id
     * @return: java.lang.String
     * @date: 2019/11/9 17:50
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:role:addUser")
    @GetMapping("/authUser/{roleId}")
    public String authUser(HttpServletRequest request,@PathVariable("roleId") String roleId,ModelMap modelMap){
        SysRoleInfo info =sysRoleInfoService.getById(roleId);
        modelMap.put("info",info);
        return SYS_ROLE_PATH + "/authUser";
    }

    /**
     * @method:  allocatedList
     * @description: <p>获取角色下用户信息 </p>
     * @params:  request
     * @Param sysUserInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/11/9 18:05
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->角色下用户列表", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:role:addUser")
    @PostMapping("/authUser/allocatedList")
    @ResponseBody
    public TableDataInfo allocatedList(HttpServletRequest request, SysUserInfo sysUserInfo){
        List<SysUserInfo> list = sysUserInfoService.allocatedList(sysUserInfo);
        return getDataTable(list);
    }

    /**
     * @method:  cancel
     * @description: <p>删除用户角色关联信息</p>
     * @params:  request
     * @Param sysUserRole
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/10 13:29
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->删除用户角色数据", businessType = BusinessType.DELETE)
    @PostMapping("/authUser/cancel")
    @ResponseBody
    public ResponseData cancel(HttpServletRequest request, SysUserRole sysUserRole){
        ResponseData data = operateFailed("取消失败");
        int state = 0;
        state = sysUserRoleService.deleteUserRoleInfo(sysUserRole);
        if (state>0){
            data = operateSucess("取消成功");
        }
        return data;
    }

    /**
     * @method:  selectUser
     * @description: <p>跳转至角色下选择用户</p>
     * @params:  request
     * @Param roleId
     * @Param modelMap
     * @return: java.lang.String
     * @date: 2019/11/10 13:46
     * @author: yanakai@126.com
     */
    @GetMapping("/authUser/selectUser/{roleId}")
    public String selectUser(HttpServletRequest request,@PathVariable("roleId") String roleId,ModelMap modelMap){
        SysRoleInfo info =sysRoleInfoService.getById(roleId);
        modelMap.put("info",info);
        return SYS_ROLE_PATH + "/selectUser";
    }

    /**
     * @method:  unallocatedList
     * @description: <p>获取不在某个角色下的所有用户列表</p>
     * @params:  request
     * @Param sysUserInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/11/10 14:04
     * @author: yanakai@126.com       
     */
    @Log(title = "角色管理-->选择用户", businessType = BusinessType.SEARCH)
    @PostMapping("/authUser/unallocatedList")
    @ResponseBody
    public TableDataInfo unallocatedList(HttpServletRequest request,SysUserInfo sysUserInfo){
        List<SysUserInfo> list = sysUserInfoService.selectUnallocatedList(sysUserInfo);
        return getDataTable(list);
    }

    /**
     * @method:  selectAll
     * @description: <p>保存用户角色信息</p>
     * @params:  request
     * @Param roleId
     * @Param userIds
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/10 15:46
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->保存用户角色", businessType = BusinessType.INSERT)
    @PostMapping("/authUser/selectAll")
    @ResponseBody
    public ResponseData selectAll(HttpServletRequest request, String roleId,String userIds){
        ResponseData data = operateFailed("保存失败");
        int state = 0;
        state = sysUserRoleService.saveUserRole(roleId,userIds);
        if (state>0){
            data = operateSucess("保存成功");
        }
        return data;
    }

    /**
     * @method:  cancelAll
     * @description: <p>批量删除用户角色信息</p>
     * @params:  request
     * @Param roleId
     * @Param userIds
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/10 16:53
     * @author: yanakai@126.com
     */
    @Log(title = "角色管理-->批量删除用户角色数据", businessType = BusinessType.DELETE)
    @PostMapping("/authUser/cancelAll")
    @ResponseBody
    public ResponseData cancelAll(HttpServletRequest request, String roleId,String userIds){
        ResponseData data = operateFailed("保存失败");
        int state = 0;
        state = sysUserRoleService.deleteUserRole(roleId,userIds);
        if (state>0){
            data = operateSucess("保存成功");
        }
        return data;
    }

}
