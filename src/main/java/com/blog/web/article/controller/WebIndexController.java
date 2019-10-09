package com.blog.web.article.controller;

import com.blog.sys.article.model.SysArticleInfo;
import com.blog.sys.article.service.ISysArticleInfoService;
import com.blog.sys.column.model.SysColumnInfo;
import com.blog.sys.column.service.ISysColumnInfoService;
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

    /**
     * 文章业务层接口
     */
    @Resource
    private ISysArticleInfoService sysArticleInfoService;

    /**
     * 栏目业务层接口
     */
    @Resource
    private ISysColumnInfoService sysColumnInfoService;

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
        sysArticleInfo.setReleaseStatus(1);
        sysArticleInfo.setDeleteStatus(0);
        List<SysArticleInfo> articleList = sysArticleInfoService.getList(sysArticleInfo);
        modelMap.put("articleList",articleList);
        //栏目列表
        List<SysColumnInfo> columnInfoList = sysColumnInfoService.getList(null);
        modelMap.put("columnInfoList",columnInfoList);
        //热文门章
        List<SysArticleInfo> hotArticleList = sysArticleInfoService.getHotArticleList(sysArticleInfo);
        modelMap.put("hotArticleList",hotArticleList);
        //置顶文章
        sysArticleInfo.setReleaseStatus(1);
        List<SysArticleInfo> topArticleList = sysArticleInfoService.getTopArticleList(sysArticleInfo);
        modelMap.put("topArticleList",topArticleList);
        return "web/article";
    }

    @RequestMapping("/article/detail")
    public String getArticle(HttpServletRequest request,String articleId, ModelMap modelMap){
        SysArticleInfo info = sysArticleInfoService.getInfoById(articleId);
        //浏览次数+1
        int chickNum = info.getChickNum()==null? 0 : info.getChickNum();
        info.setChickNum(chickNum+1);
        sysArticleInfoService.updateNotNull(info);
        modelMap.put("info",info);
        return "web/read";
    }
}
