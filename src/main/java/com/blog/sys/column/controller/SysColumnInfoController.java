package com.blog.sys.column.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.blog.sys.column.model.SysColumnInfo;
import com.blog.sys.column.service.ISysColumnInfoService;
import com.blog.sys.common.annotation.Log;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.enums.BusinessType;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.column.controller
 * @ClassName: SysColumnInfoController
 * @Description: 文章栏目controller
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/23 22:03
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/23 22:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sys/column")
public class SysColumnInfoController extends BaseController {
    private static final String SYS_COLUMN_PATH = "sys/column";

    /**
     * 文章栏目业务层接口
     */
    @Resource
    private ISysColumnInfoService sysColumnInfoService;

    /**
     * @method:  columnList
     * @description: <p>跳转至栏目列表页面</p>
     * @params:  []
     * @return java.lang.String
     * @date: 2019/9/23 22:35
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:column:view")
    @GetMapping("/list")
    public String columnList(){
        return SYS_COLUMN_PATH+"/list";
    }

    /**
     * @method:  columnPage
     * @description: <p>获取column列表数据</p>
     * @params:  [request, sysColumnInfo]
     * @return com.yk.blog.common.base.TableDataInfo
     * @date: 2019/9/23 22:35
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:column:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo columnPage(HttpServletRequest request, SysColumnInfo sysColumnInfo){
        startPage();
        List<SysColumnInfo> list = sysColumnInfoService.getList(sysColumnInfo);
        return getDataTable(list);
    }

    /**
     * @method:  add
     * @description: <p>跳转至添加页面</p>
     * @params:  [request]
     * @return java.lang.String
     * @date: 2019/9/23 22:35
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:column:add")
    @GetMapping("/add")
    public String add(HttpServletRequest request){
        return SYS_COLUMN_PATH+"/add";
    }

    /**
     * @method:  add
     * @description: <p>跳转至栏目编辑页面</p>
     * @params:  [request, columnId, modelMap]
     * @return java.lang.String
     * @date: 2019/9/23 22:53
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:column:edit")
    @GetMapping("/edit/{columnId}")
    public String add(HttpServletRequest request, @PathVariable("columnId") Long columnId, ModelMap modelMap){
        if (columnId != null){
            SysColumnInfo sysColumnInfo = sysColumnInfoService.selectByPrimaryKey(columnId);
            modelMap.put("info",sysColumnInfo);
        }
        return SYS_COLUMN_PATH+"/edit";
    }

    /**
     * @method:  saveOrUpdate
     * @description: <p>新增或者保存数据</p>
     * @params:  [request, sysColumnInfo]
     * @return com.yk.blog.common.base.ResponseData
     * @date: 2019/9/23 22:49
     * @author: yanakai@126.com
     */
    @Log(title = "栏目管理-->保存数据", businessType = BusinessType.INSERT)
    @RequiresPermissions(value={"sys:column:add","sys:column:edit"},logical= Logical.OR)
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseData saveOrUpdate(HttpServletRequest request, SysColumnInfo sysColumnInfo){
        ResponseData data = operateFailed("保存失败");
        int state = 0;
        if (sysColumnInfo.getColumnId() == null){
            state = sysColumnInfoService.saveNotNUll(sysColumnInfo);
        }else {
            state = sysColumnInfoService.updateNotNUll(sysColumnInfo);
        }
        if (state>0){
            data = operateSucess("保存成功");
        }
        return data;
    }

    /**
     * @method:  deleteById
     * @description: <p>通过主键删除对象</p>
     * @params:  [columnId]
     * @return com.yk.blog.common.base.ResponseData
     * @date: 2019/9/23 22:56
     * @author: yanakai@126.com
     */
    @Log(title = "栏目管理-->删除数据", businessType = BusinessType.DELETE)
    @RequiresPermissions("sys:column:del")
    @PostMapping("/deleteById")
    @ResponseBody
    public ResponseData deleteById(Long columnId){
        ResponseData data = operateFailed("删除失败");
        int state = 0;
        state = sysColumnInfoService.deleteByPrimaryKey(columnId);
        if (state>0){
            data = operateSucess("删除成功");
        }
        return data;
    }

    /**
     * @method:  checkColumnNameUnique
     * @description: <p>校验栏目名称是否已存在</p>
     * @params:  [sysColumnInfo]
     * @return java.lang.String
     * @date: 2019/9/23 23:33
     * @author: yanakai@126.com
     */
    @PostMapping("/checkColumnNameUnique")
    @ResponseBody
    public String checkColumnNameUnique(SysColumnInfo sysColumnInfo){
        return sysColumnInfoService.checkColumnNameUnique(sysColumnInfo);
    }
}
