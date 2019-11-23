package com.blog.sys.log.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.log.model.SysLoginInfo;
import com.blog.sys.log.service.ISysLoginInfoService;
import com.blog.sys.shiro.service.SysPasswordService;
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
     * 密码操作业务层接口
     */
    @Resource
    private SysPasswordService passwordService;


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
        sysLoginInfoService.cleanLoginInfo();
        return operateSucess("操作成功");
    }

    /**
     * @method:  deleteByIds
     * @description: <p>批量删除登录日志数据</p>
     * @params:  ids 主键ids
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/23 20:26
     * @author: yanakai@126.com
     */
    @PostMapping("remove")
    @ResponseBody
    public ResponseData deleteByIds(String ids){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        state = sysLoginInfoService.deleteByIds(ids);
        if (state>0){
            data = operateSucess("操作成功");
        }
        return data;
    }

    /**
     * @method:  unlock
     * @description: <p>解除登录失败造成账号被锁住</p>
     * @params:  loginName
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/23 17:55
     * @author: yanakai@126.com
     */
    @PostMapping("/unlock")
    @ResponseBody
    public ResponseData unlock(String loginName){
        passwordService.unlock(loginName);
        return operateSucess("操作成功");
    }

}
