package com.blog.sys;

import com.blog.sys.menu.model.SysMenuInfo;
import com.blog.sys.menu.service.ISysMenuInfoService;
import com.blog.sys.shiro.utils.ShiroUtils;
import com.blog.sys.user.model.SysUserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys
 * @ClassName: IndexController
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/24 21:58
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/24 21:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class IndexController {

    /**
     * 菜单业务层接口
     */
    @Resource
    private ISysMenuInfoService sysMenuInfoService;
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
        //根据当前登录用户信息查询目录和菜单
        List<SysMenuInfo> menuList=sysMenuInfoService.getMenuListByUser(sysUserInfo);
        model.addAttribute("menuList", menuList);
        model.addAttribute("user", sysUserInfo);
        return "/sys/index";
    }
    // 系统介绍页
    @GetMapping("/sys/main")
    public String main(Model model) {
        return "/sys/main";
    }

    // 切换主题
    @GetMapping("/sys/switchSkin")
    public String switchSkin(ModelMap modelMap)
    {
        return "/sys/skin";
    }

}
