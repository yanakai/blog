package com.blog.sys.role.controller;

import cn.hutool.core.util.StrUtil;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.UserConstants;
import com.blog.sys.role.model.SysRoleInfo;
import com.blog.sys.role.service.ISysRoleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
     * @Title: pageList
     * @Description:  跳转至角色列表页面
     * @Param: request
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/11/8
     */
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
    @PostMapping("/changeStatus")
    @ResponseBody
    public ResponseData changeStatus(HttpServletRequest request,SysRoleInfo sysRoleInfo){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        sysRoleInfo.setUpdateTime(new Date());
        sysRoleInfo.setUpdateBy("暂无登录者");
        state = sysRoleInfoService.updateNotNull(sysRoleInfo);
        if (state>0){
            data = operateSucess("操作成功");
        }
        return data;
    }
}
