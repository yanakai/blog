package com.blog.web.controller;

import com.blog.sys.article.model.SysArticleInfo;
import com.blog.sys.article.service.ISysArticleInfoService;
import com.blog.sys.column.model.SysColumnInfo;
import com.blog.sys.column.service.ISysColumnInfoService;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @Title: navInfo
     * @Description:  导航页面跳转
     * @Param: request
     * @Param nav 导航名称
     * @return: java.lang.String
     * @author: yankai
     * @date   2019-12-12
     */
    @GetMapping("/{nav}")
    public String navInfo(HttpServletRequest request,@PathVariable("nav") String nav){
        return "web/"+nav;
    }



    /**
     * @Title: getColumnList
     * @Description:  获取栏目列表数据
     * @Param: request
     * @Param sysColumnInfo
     * @return: com.blog.sys.common.base.ResponseData
     * @author: yankai
     * @date   2019-12-10
     */
    @RequestMapping("/article/getColumnList")
    @ResponseBody
    public ResponseData getColumnList(HttpServletRequest request ,SysColumnInfo sysColumnInfo){
        ResponseData data = operateFailed("暂无数据");
        List<SysColumnInfo> list = sysColumnInfoService.getList(sysColumnInfo);
        if (list.size()>0){
            data = operateSucess();
            data.setData(list);
        }
        return data;
    }

    /**
     * @Title: getArticleList
     * @Description:  获取文章列表  根据传入的参数不同获取不同的文章数据
     * @Param: request
     * @Param sysArticleInfo
     * @return: com.blog.sys.common.base.ResponseData
     * @author: yankai
     * @date   2019-12-10
     */
    @RequestMapping("article/getList")
    @ResponseBody
    public TableDataInfo getArticleList(HttpServletRequest request ,SysArticleInfo sysArticleInfo){
        startPage();
        List<SysArticleInfo> list = sysArticleInfoService.getList(sysArticleInfo);
        return getDataTable(list);
    }


    /**
     * @Title: getArticleListByHotColumn
     * @Description:  获取热点栏目及栏目下文章 每个栏目下文章获取5条
     * @Param: request
     * @return: com.blog.sys.common.base.ResponseData
     * @author: yankai
     * @date   2019-12-10
     */
    @RequestMapping("/article/getArticleListByHotColumn")
    @ResponseBody
    public ResponseData getArticleListByHotColumn(HttpServletRequest request){
        ResponseData data = new ResponseData();
        Map<String,List<SysArticleInfo>> map = new HashMap<>();
        //获取推荐栏目信息
        SysColumnInfo columnInfo = new SysColumnInfo();
        List<SysColumnInfo> columnInfoList = sysColumnInfoService.getList(columnInfo);
        SysArticleInfo sysArticleInfo = new SysArticleInfo();
        if (columnInfoList !=null && columnInfoList.size()>0){
            for (SysColumnInfo temp:columnInfoList){
                List<SysArticleInfo> list = sysArticleInfoService.getArticleListByColumnId(temp.getColumnId());
                if (list != null && list.size()>0){
                    map.put(temp.getColumnName(),list);
                }

            }
        }
        if (map.size()>0){
            data = operateSucess();
            data.setData(map);
        }
        return data;
    }


    /**
     * @Title: getArticle
     * @Description:  跳转至文章详情页
     * @Param: request
     * @Param articleId 文章主键id
     * @Param modelMap
     * @return: java.lang.Long
     * @author: yankai
     * @date   2019-12-09
     */
    @RequestMapping("/article/details/{articleId}")
    public String getArticle(HttpServletRequest request, @PathVariable("articleId") Long articleId, ModelMap modelMap){
        SysArticleInfo info = sysArticleInfoService.getInfoById(articleId);
        //浏览次数+1
        int chickNum = info.getChickNum()==null? 0 : info.getChickNum();
        info.setChickNum(chickNum+1);
        sysArticleInfoService.updateNotNull(info);
        modelMap.put("info",info);
        return "web/read";
    }
}
