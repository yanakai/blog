package com.yk.blog.article.controller;

import com.yk.blog.article.model.SysArticleInfo;
import com.yk.blog.article.service.ISysArticleInfoService;
import com.yk.blog.common.base.BaseController;
import com.yk.blog.common.base.TableDataInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.article.controller
 * @ClassName: SysArticleInfoController
 * @Description: 文章控制类
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/21 22:21
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/21 22:21
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sys/article")
public class SysArticleInfoController extends BaseController {
    //基础路径
    private final static String SYS_ARTICLE_PATH = "sys/article";

    /**
     * 文章业务层接口
     */
    @Resource
    private ISysArticleInfoService sysArticleInfoService;

    @GetMapping("/list")
    public String articleList(){
        return SYS_ARTICLE_PATH+"/list";
    }

    @PostMapping("list")
    @ResponseBody
    public TableDataInfo articlePage(HttpServletRequest request, SysArticleInfo sysArticleInfo){
        //初始化分页
        startPage();
        List<SysArticleInfo> list = sysArticleInfoService.getList(sysArticleInfo);
        return getDataTable(list);
    }
}
