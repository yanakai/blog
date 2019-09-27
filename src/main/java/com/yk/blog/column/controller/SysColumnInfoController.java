package com.yk.blog.column.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.yk.blog.column.model.SysColumnInfo;
import com.yk.blog.column.service.ISysColumnInfoService;
import com.yk.blog.common.base.BaseController;
import com.yk.blog.common.base.ResponseData;
import com.yk.blog.common.base.TableDataInfo;
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
    private static final String SYS_COLUMN_PATH = "/sys/column";

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
    @GetMapping("/edit/{columnId}")
    public String add(HttpServletRequest request, @PathVariable("columnId") String columnId, ModelMap modelMap){
        if (StrUtil.isNotEmpty(columnId)){
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
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseData saveOrUpdate(HttpServletRequest request,SysColumnInfo sysColumnInfo){
        ResponseData data = operateFailed("保存失败");
        int state = 0;
        if (StrUtil.isEmpty(sysColumnInfo.getColumnId())){
            sysColumnInfo.setColumnId(UUID.randomUUID().toString());
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
    @PostMapping("/deleteById")
    @ResponseBody
    public ResponseData deleteById(String columnId){
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
