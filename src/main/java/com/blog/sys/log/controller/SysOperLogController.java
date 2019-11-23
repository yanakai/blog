package com.blog.sys.log.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.log.model.SysOperLog;
import com.blog.sys.log.service.ISysOperLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("/list")
    public String pageList(HttpServletRequest request, ModelMap modelMap){
        return SYS_OPERLOG_PATH + "/operLog";
    }

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
    @PostMapping("/clean")
    @ResponseBody
    public ResponseData clean(){
        sysOperLogService.cleanLoginInfo();
        return operateSucess("操作成功");
    }

}
