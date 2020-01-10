package com.blog.sys.online.controller;

import com.blog.sys.common.annotation.Log;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.enums.BusinessType;
import com.blog.sys.common.enums.OnlineStatus;
import com.blog.sys.online.model.SysUserOnline;
import com.blog.sys.online.service.ISysUserOnlineService;
import com.blog.sys.shiro.session.OnlineSession;
import com.blog.sys.shiro.session.OnlineSessionDAO;
import com.blog.sys.shiro.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.online.controller
 * @ClassName: SysUserOnlineController
 * @Description: 用户在线业务层
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/26 22:13
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/26 22:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sys/online")
public class SysUserOnlineController extends BaseController {

    private static final String SYS_ONLINE_PATH = "sys/online";
    /**
     * 用户在线业务成接口
     */
    @Resource
    private ISysUserOnlineService sysUserOnlineService;

    @Resource
    private OnlineSessionDAO onlineSessionDAO;

    /**
     * @method:  pageList
     * @description: <p>跳转至用户在线列表页面</p>
     * @params:
     * @return: java.lang.String
     * @date: 2019/11/26 22:19
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:online:view")
    @GetMapping("/list")
    public String pageList(ModelMap modelMap){
        return SYS_ONLINE_PATH + "/list";
    }

    /**
     * @method:  tableDataInfo
     * @description: <p>获取用户在线数据</p>
     * @params:  sysUserOnline 用户在线列表
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/11/27 22:32
     * @author: yanakai@126.com
     */
    @Log(title = "在线用户-->在线列表",businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:online:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo tableDataInfo(SysUserOnline sysUserOnline){
        startPage();
        List<SysUserOnline> list = sysUserOnlineService.getList(sysUserOnline);
        return getDataTable(list);
    }

    /**
     * @method:  forceLogout
     * @description: <p>单个用户强退功能</p>
     * @params:  sessionId 在线用户sessionId
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/11/27 23:08
     * @author: yanakai@126.com
     */
    @Log(title = "在线用户-->单个用户强退",businessType = BusinessType.FORCE)
    @RequiresPermissions("sys:online:forceLogout")
    @PostMapping("/forceLogout")
    @ResponseBody
    public ResponseData forceLogout(String sessionId){
        ResponseData data = operateSucess();
        SysUserOnline online = sysUserOnlineService.getById(sessionId);
        //判断当前操作者强退的用户是否本账户
        if (sessionId.equals(ShiroUtils.getSessionId())){
            return operateFailed("当前登陆用户无法强退");
        }
        if (online == null){
            return operateFailed("此用户已下线");
        }
        OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
        if (onlineSession == null){
            return operateFailed("用户已下线");
        }
        onlineSession.setStatus(OnlineStatus.off_line);
        onlineSessionDAO.update(onlineSession);
        online.setStatus(OnlineStatus.off_line.toString());
        sysUserOnlineService.saveOnline(online);
        return data;
    }

    /**
     * @method:  batchForceLogout
     * @description: <p>批量用户强退</p>
     * @params:  ids
     * @return: com.blog.sys.common.base.ResponseData
     * @date: 2019/12/1 22:41
     * @author: yanakai@126.com
     */
    @RequiresPermissions("sys:online:batchForceLogout")
    @Log(title = "在线用户-->批量强退", businessType = BusinessType.FORCE)
    @PostMapping("/batchForceLogout")
    @ResponseBody
    public ResponseData batchForceLogout(@RequestParam("ids[]") String[] ids){
        for (String sessionId : ids){
            SysUserOnline online = sysUserOnlineService.getById(sessionId);
            if (online == null){
                return operateFailed("用户已下线");
            }
            OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
            if (onlineSession == null){
                return operateFailed("用户已下线");
            }
            if (sessionId.equals(ShiroUtils.getSessionId()))
            {
                return operateFailed("当前登陆用户无法强退");
            }
            onlineSession.setStatus(OnlineStatus.off_line);
            onlineSessionDAO.update(onlineSession);
            online.setStatus(OnlineStatus.off_line.toString());
            sysUserOnlineService.saveOnline(online);
        }
        return operateSucess();
    }
}
