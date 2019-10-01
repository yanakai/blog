package com.blog.web.article.controller;

import com.blog.sys.article.model.SysArticleInfo;
import com.blog.sys.article.service.ISysArticleInfoService;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.TableDataInfo;
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
 * @Package: com.blog.web.controller
 * @ClassName: WebIndexController
 * @Description: 博客首页
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/30 22:55
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/30 22:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("web")
public class WebIndexController extends BaseController {

    @Resource
    private ISysArticleInfoService sysArticleInfoService;

    /**
     * @method:  index
     * @description: <p>首页方法</p>
     * @params:  request
     * @return: java.lang.String
     * @date: 2019/9/30 23:13
     * @author: yanakai@126.com
     */
    @GetMapping({"","/index"})
    public String index(HttpServletRequest request){
        return "web/index";
    }

    /**
     * @method:  articleList
     * @description: <p>跳转至文章列表页面</p>
     * @params:  request
     * @Param modelMap
     * @return: java.lang.String
     * @date: 2019/10/1 0:04
     * @author: yanakai@126.com
     */
    @RequestMapping("/article/list")
    public String articleList(HttpServletRequest request,SysArticleInfo sysArticleInfo, ModelMap modelMap){
        startPage();
        List<SysArticleInfo> list = sysArticleInfoService.getList(sysArticleInfo);
        modelMap.put("list",list);
        return "web/article";
    }

    @GetMapping("/article/detail")
    public String getArticle(HttpServletRequest request,String articleId, ModelMap modelMap){
        return "web/read";
    }
}
