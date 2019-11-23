package com.blog.sys.log.controller;

import com.blog.sys.common.annotation.Log;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.enums.BusinessType;
import com.blog.sys.log.model.SysOperLog;
import com.blog.sys.log.service.ISysOperLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.log.controller
 * @ClassName: SysOperLogController
 * @Description: 操作日志控制层
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/23 16:25
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/23 16:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sys/operLog")
public class SysOperLogController extends BaseController {

    private static final String SYS_OPERLOG_PATH="/sys/log";

    /**
     * 操作日志业务层接口
     */
    @Resource
    private ISysOperLogService sysOperLogService;

    /**
     * @method:  pageList
     * @description: <p>跳转至操作日志列表页面</p>
     * @params:  request
     * @Param modelMap
     * @return: java.lang.String
     * @date: 2019/11/23 16:29
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:operLog:view")
    @GetMapping("/list")
    public String pageList(HttpServletRequest request, ModelMap modelMap){
        return SYS_OPERLOG_PATH + "/operLog";
    }

    /**
     * @method:  tableDataList
     * @description: <p>查询操作日志列表</p>
     * @params:  sysOperLog
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/11/23 19:44
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:operLog:list")
    @Log(title = "操作日志-->查询列表", businessType = BusinessType.SEARCH)
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo tableDataList(SysOperLog sysOperLog){
        startPage();
        List<SysOperLog> list = sysOperLogService.getList(sysOperLog);
        return getDataTable(list);
    }

    /**
     * @method:  deleteByIds
     * @description: <p>批量删除数据</p>
     * @params:  ids 主键ids
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/23 16:54
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:operLog:del")
    @Log(title = "操作日志-->删除数据", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public ResponseData deleteByIds(String ids){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        state = sysOperLogService.deleteByIds(ids);
        if(state>0)data = operateSucess("操作成功");
        return data;
    }

    /**
     * @method:  clean
     * @description: <p>清空日志数据</p>
     * @params:
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/23 17:03
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:operLog:clean")
    @Log(title = "操作日志-->清空数据", businessType = BusinessType.CLEAN)
    @PostMapping("/clean")
    @ResponseBody
    public ResponseData clean(){
        sysOperLogService.cleanLoginInfo();
        return operateSucess("操作成功");
    }

    /**
     * @method:  detail
     * @description: <p>查看操作日志详情</p>
     * @params:  operId 操作日志id
     * @Param mmap
     * @return: java.lang.String
     * @date: 2019/11/23 20:08
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:operLog:detail")
    @Log(title = "操作日志-->查询详情", businessType = BusinessType.SEARCH)
    @GetMapping("/detail/{operId}")
    public String detail(@PathVariable("operId") String operId, ModelMap mmap){
        mmap.put("operLog", sysOperLogService.getById(operId));
        return SYS_OPERLOG_PATH + "/detail";
    }

}
