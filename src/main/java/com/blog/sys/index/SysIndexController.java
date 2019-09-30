package com.blog.sys.index;

import com.blog.sys.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysIndexController extends BaseController {

    @RequestMapping({"","/sys/index"})
    public String index(){
        return "sys/index";
    }
    @RequestMapping("/sys/main")
    public String main(){
        return "sys/main";
    }
}
