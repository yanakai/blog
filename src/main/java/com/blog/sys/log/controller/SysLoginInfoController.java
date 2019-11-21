package com.blog.sys.log.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.log.model.SysLoginInfo;
import com.blog.sys.log.service.ISysLoginInfoService;
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
 * @ClassName: SysLoginInfoController
 * @Description: 登录日志控制层
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/20 22:23
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/20 22:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("sys/loginLog")
public class SysLoginInfoController extends BaseController {

    private static final String SYS_LOGININFO_PATH="/sys/log";
    /**
     * 登录日志业务层接口
     */
    @Resource
    private ISysLoginInfoService sysLoginInfoService;


    /**
     * @method:  pageList
     * @description: <p>跳转至的登录日志列表页面</p>
     * @params:  request
     * @Param modelMap
     * @return: java.lang.String
     * @date: 2019/11/20 22:27
     * @author: yanakai@126.com
     */
    @GetMapping("/list")
    public String pageList(HttpServletRequest request, ModelMap modelMap){
        return SYS_LOGININFO_PATH + "/loginInfo";
    }

    /**
     * @method:  tableDataList
     * @description: <p>获取登录日志列表数据信息</p>
     * @params:  sysLoginInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/11/20 22:43
     * @author: yanakai@126.com
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo tableDataList(SysLoginInfo sysLoginInfo){
        startPage();
        List<SysLoginInfo> list = sysLoginInfoService.getList(sysLoginInfo);
        return getDataTable(list);
    }


    @PostMapping("/clean")
    @ResponseBody
    public ResponseData clean(){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        state = sysLoginInfoService.cleanLoginInfo();
        if (state>0){
            data = operateSucess("操作成功");
        }
        return data;
    }


}
