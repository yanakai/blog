package com.blog.sys.shiro.controller;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.menu.model.SysMenuInfo;
import com.blog.sys.menu.service.ISysMenuInfoService;
import com.blog.sys.shiro.utils.ShiroUtils;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.shiro.controller
 * @ClassName: LoginController
 * @Description: 登录控制层
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/12 22:32
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/12 22:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class LoginController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    /**
     * 用户业务层接口
     */
    @Resource
    private ISysUserInfoService sysUserInfoService;

    /**
     * 菜单业务层接口
     */
    @Resource
    private ISysMenuInfoService sysMenuInfoService;

    @GetMapping({"/login","/sys"})
    public String login() {
        return "/sys/login";
    }
    /**
     * @method:  unauthorize
     * @description: <p>无权限跳转页面</p>
     * @params:
     * @return: java.lang.String
     * @date: 2019/11/12 22:34
     * @author: yanakai@126.com
     */
    @RequestMapping("/unauthorize")
    public String unauthorize() {
        return "/error/unauthorize";
    }
    /**
     * @method:  logout
     * @description: <p>退出返回登录页面</p>
     * @params:
     * @return: java.lang.String
     * @date: 2019/11/12 22:35
     * @author: yanakai@126.com
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    /**
     * @method:  userLoginWithRealmAction
     * @description: <p>登录 </p>
     * @params:  userName 用户名
     * @Param password 密码
     * @return: ResponseData
     * @date: 2019/11/12 22:35
     * @author: yanakai@126.com       
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseData userLoginWithRealmAction (@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password){
        //登录对象放入token
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try{
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            log.info("对用户[" + userName + "]进行登录验证..验证开始");
            subject.login(token);
            log.info("对用户[" + userName + "]进行登录验证..验证通过");
            return operateSucess();
        } catch (UnknownAccountException uae) {
            log.error("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
            return operateFailed("未知账户");
        } catch (IncorrectCredentialsException ice) {
            log.error("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
            return operateFailed("密码不正确");
        } catch (LockedAccountException lae) {
            log.error("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
            return operateFailed("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            log.error("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
            return operateFailed("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            log.error("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            return operateFailed("用户名或密码不正确");
        }
    }

    /**
     *
     * <p>Title: index</p>
     * <p>Description: 跳转值系统首页</p>
     * @param: model
     * @return
     * @author yanakai@126.com
     * @date 2019年7月27日
     */
    @RequestMapping(value="index",method = RequestMethod.GET)
    public String index(Model model){
        SysUserInfo sysUserInfo= ShiroUtils.getSysUser();
        //查询目录和菜单
        List<SysMenuInfo> menuList=sysMenuInfoService.getMenuListByUser(sysUserInfo);
        model.addAttribute("menuList", menuList);
        model.addAttribute("user", sysUserInfo);
        return "/sys/index";
    }

    // 系统介绍页
    @GetMapping("/sys/main")
    public String main(Model model){

        return "/sys/main";
    }
}
