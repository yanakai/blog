package com.yk.blog.sys;

import com.yk.blog.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.sys
 * @ClassName: SysIndexController
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/22 18:36
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/22 18:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sys")
public class SysIndexController extends BaseController {

    //后台系统首页
    @GetMapping({"","index"})
    public String sysIndex(){
        return "sys/index";
    }

    // 系统介绍
    @GetMapping("/main")
    public String main(ModelMap mmap){
        return "sys/main";
    }
}
