package com.blog.sys.article.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.blog.sys.article.model.SysArticleInfo;
import com.blog.sys.article.service.ISysArticleInfoService;
import com.blog.sys.column.model.SysColumnInfo;
import com.blog.sys.column.service.ISysColumnInfoService;
import com.blog.sys.common.annotation.Log;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.enums.BusinessType;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.shiro.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @RequiresPermissions("sys:article:view")
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
    @Log(title = "文章管理-->查询列表", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:article:list")
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
    @Log(title = "文章管理-->发布文章/置顶文章", businessType = BusinessType.UPDATE)
    @RequiresPermissions(value={"sys:article:rel","sys:article:top"},logical= Logical.OR)
    @PostMapping("/changeStatus")
    @ResponseBody
    public ResponseData changeStatus(HttpServletRequest request, SysArticleInfo sysArticleInfo){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        sysArticleInfo.setReleaseTime(new Date());
        sysArticleInfo.setReleaseUser(ShiroUtils.getUserId());
        sysArticleInfo.setReleaseName(ShiroUtils.getSysUser().getTrueName());
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
    @Log(title = "文章管理-->删除文章", businessType = BusinessType.DELETE)
    @RequiresPermissions("sys:article:del")
    @PostMapping("/deleteById")
    @ResponseBody
    public ResponseData virtualDeleteById(HttpServletRequest request,Long articleId){
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
    @Log(title = "文章管理-->文章添加页面", businessType = BusinessType.SEARCH)
    @RequiresPermissions("sys:article:add")
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
    @RequiresPermissions("sys:article:edit")
    @GetMapping("/edit/{articleId}")
    public String edit(@PathVariable("articleId")Long articleId, ModelMap modelMap){
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
    @Log(title = "文章管理-->保存文章", businessType = BusinessType.INSERT)
    @RequiresPermissions(value={"sys:article:add","sys:article:edit"},logical= Logical.OR)
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseData saveOrUpdate(SysArticleInfo sysArticleInfo){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        if (sysArticleInfo.getArticleId()!=null){
            sysArticleInfo.setLastModifyTime(new Date());
            sysArticleInfo.setLastModifyName(ShiroUtils.getSysUser().getTrueName());
            state = sysArticleInfoService.updateNotNull(sysArticleInfo);
        }else {
            sysArticleInfo.setCreateTime(new Date());
            sysArticleInfo.setCreateUser(ShiroUtils.getUserId());
            sysArticleInfo.setCreateName(ShiroUtils.getSysUser().getTrueName());
            sysArticleInfo.setLastModifyTime(sysArticleInfo.getCreateTime());
            sysArticleInfo.setLastModifyName(ShiroUtils.getSysUser().getTrueName());
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
    @RequiresPermissions("sys:article:pre")
    @GetMapping("/detail/{articleId}")
    public String detail(HttpServletRequest request,@PathVariable("articleId") Long articleId,ModelMap modelMap){
        if (articleId != null){
            SysArticleInfo info = sysArticleInfoService.getInfoById(articleId);
            modelMap.put("info",info);
        }
        return SYS_ARTICLE_PATH + "/detail";
    }
}
