package com.blog.sys.user.controller;

import cn.hutool.core.lang.UUID;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.springframework.stereotype.Controller;
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
     * @method:  pageList
     * @description: <p>跳转至用户列表页面</p>
     * @params: request
     * @return: java.lang.String
     * @date: 2019/11/6 21:26
     * @author: yanakai@126.com
     */
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
    @GetMapping("/add")
    public String add(HttpServletRequest request, ModelMap modelMap){
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
    @GetMapping("/edit/{userId}")
    public String edit(HttpServletRequest request, @PathVariable("userId") String userId, ModelMap modelMap){
        SysUserInfo info = sysUserInfoService.getById(userId);
        modelMap.put("info",info);
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
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseData saveOrUpdate(HttpServletRequest request,SysUserInfo sysUserInfo){
        ResponseData data = operateFailed("保存失败");
        int state = 0;
        if (StringUtils.isNotEmpty(sysUserInfo.getUserId())){
            sysUserInfo.setModifyTime(new Date());
            state = sysUserInfoService.updateNotNull(sysUserInfo);
        }else {
            sysUserInfo.setUserId(UUID.randomUUID().toString());
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


}
