package com.blog.sys.article.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.blog.sys.article.model.SysArticleInfo;
import com.blog.sys.column.model.SysColumnInfo;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.article.service.ISysArticleInfoService;
import com.blog.sys.column.service.ISysColumnInfoService;
import com.blog.sys.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    /**
     * 文章栏目业务层接口
     */
    @Resource
    private ISysColumnInfoService sysColumnInfoService;

    /**
     * @method:  articleList
     * @description: <p>跳转至文章列表页</p>
     * @params:  []
     * @return java.lang.String
     * @date: 2019/9/22 23:26
     * @author: yanakai@126.com
     */
    @GetMapping("/list")
    public String articleList(){
        return SYS_ARTICLE_PATH+"/list";
    }

    /**
     * @method:  articlePage
     * @description: <p>获取文章列表数据分页</p>
     * @params:  [request, sysArticleInfo]
     * @return com.yk.blog.common.base.TableDataInfo
     * @date: 2019/9/22 23:27
     * @author: yanakai@126.com
     */
    @PostMapping("list")
    @ResponseBody
    public TableDataInfo articlePage(HttpServletRequest request, SysArticleInfo sysArticleInfo){
        //初始化分页
        startPage();
        sysArticleInfo.setDeleteStatus(0);
        List<SysArticleInfo> list = sysArticleInfoService.getList(sysArticleInfo);
        return getDataTable(list);
    }

    /**
     * @method:  changeStatus
     * @description: <p>文章公共修改状态方法：文章发布、文章置顶</p>
     * @params:  [request, sysArticleInfo]
     * @return com.yk.blog.common.base.ResponseData
     * @date: 2019/9/22 23:27
     * @author: yanakai@126.com
     */
    @PostMapping("/changeStatus")
    @ResponseBody
    public ResponseData changeStatus(HttpServletRequest request, SysArticleInfo sysArticleInfo){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        sysArticleInfo.setReleaseTime(new Date());
        sysArticleInfo.setReleaseName("暂时没有问题登录系统");
        state = sysArticleInfoService.updateNotNull(sysArticleInfo);
        if (state>0) data = operateSucess("操作成功");
        return data;
    }

    /**
     * @method:  virtualDeleteById
     * @description: <p>通过主键id虚拟删除修改删除状态</p>
     * @params:  [request, articleId]
     * @return com.yk.blog.common.base.ResponseData
     * @date: 2019/9/23 0:06
     * @author: yanakai@126.com
     */
    @PostMapping("/deleteById")
    @ResponseBody
    public ResponseData virtualDeleteById(HttpServletRequest request,String articleId){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        SysArticleInfo sysArticleInfo = sysArticleInfoService.getInfoById(articleId);
        sysArticleInfo.setDeleteStatus(1);
        state = sysArticleInfoService.updateNotNull(sysArticleInfo);
        if (state>0) data = operateSucess("操作成功");
        return data;
    }

    /**
     * @Title: add
     * @Description:  跳转至文章添加页面
     * @Param: modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/9/24
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap){
        //获取所有的文章栏目
        List<SysColumnInfo> columnInfoList=sysColumnInfoService.getList(null);
        modelMap.put("columnInfoList",columnInfoList);
        return SYS_ARTICLE_PATH+"/add";
    }

    /**
     * @Title: edit
     * @Description:  跳转至文章编辑页面
     * @Param: articleId
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/9/24
     */
    @GetMapping("/edit/{articleId}")
    public String edit(@PathVariable("articleId") String articleId, ModelMap modelMap){
        //获取所有的文章栏目
        List<SysColumnInfo> columnInfoList=sysColumnInfoService.getList(null);
        modelMap.put("columnInfoList",columnInfoList);
        SysArticleInfo sysArticleInfo = sysArticleInfoService.getInfoById(articleId);
        modelMap.put("info",sysArticleInfo);
        return SYS_ARTICLE_PATH+"/edit";
    }

    /**
     * @Title: saveOrUpdate
     * @Description:  保存或者添加文章数据
     * @Param: sysArticleInfo
     * @return: com.yk.blog.common.base.ResponseData
     * @author: yankai
     * @date   2019/9/24
     */
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseData saveOrUpdate(SysArticleInfo sysArticleInfo){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        if (StrUtil.isNotEmpty(sysArticleInfo.getArticleId())){
            sysArticleInfo.setLastModifyTime(new Date());
            sysArticleInfo.setLastModifyName("目前没有登录系统");
            state = sysArticleInfoService.updateNotNull(sysArticleInfo);
        }else {
            sysArticleInfo.setArticleId(UUID.randomUUID().toString());
            sysArticleInfo.setCreateTime(new Date());
            sysArticleInfo.setCreateName("目前没有登录系统");
            sysArticleInfo.setLastModifyTime(sysArticleInfo.getCreateTime());
            sysArticleInfo.setLastModifyName("目前没有登录系统");
            state = sysArticleInfoService.saveNotNull(sysArticleInfo);
        }
        if (state>0) data = operateSucess("操作成功");
        return data;
    }

    /**
     * @Title: detail
     * @Description:  跳转至文章详情页
     * @Param: request
     * @Param articleId 文章id
     * @Param modelMap
     * @return: java.lang.String
     * @author: yankai
     * @date   2019/9/29
     */
    @GetMapping("/detail/{articleId}")
    public String detail(HttpServletRequest request,@PathVariable("articleId") String articleId,ModelMap modelMap){
        if (StringUtils.isNotEmpty(articleId)){
            SysArticleInfo info = sysArticleInfoService.getInfoById(articleId);
            modelMap.put("info",info);
        }
        return SYS_ARTICLE_PATH + "/detail";
    }
}