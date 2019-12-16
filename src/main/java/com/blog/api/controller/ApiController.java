package com.blog.api.controller;

import com.blog.sys.article.model.SysArticleInfo;
import com.blog.sys.article.service.ISysArticleInfoService;
import com.blog.sys.column.model.SysColumnInfo;
import com.blog.sys.column.service.ISysColumnInfoService;
import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.base.TableDataInfo;
import com.blog.sys.common.config.Global;
import com.blog.sys.common.config.ServerConfig;
import com.blog.sys.common.utils.file.FileUploadUtils;
import com.blog.sys.role.model.SysRoleInfo;
import com.blog.sys.role.service.ISysRoleInfoService;
import com.blog.sys.shiro.utils.ShiroUtils;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: blog
 * @Package: com.blog.api.controller
 * @ClassName: ApiController
 * @Description: 对外接口
 * @Author: yanakai@126.com
 * @CreateDate: 2019/12/14 16:51
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/12/14 16:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController()
@RequestMapping("/api")
public class ApiController extends BaseController {

    /**
     * 服务配置类
     */
    @Resource
    private ServerConfig serverConfig;
    /**
     * 用户业务层接口
     */
    @Resource
    private ISysUserInfoService sysUserInfoService;
    /**
     * 角色业务层接口
     */
    @Resource
    private ISysRoleInfoService sysRoleInfoService;
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
     * @Title: updateFile
     * @Description:  公共上传方法
     * @Param: file
     * @return: com.blog.sys.common.base.ResponseData
     * @author: yankai
     * @date   2019-12-16
     */
    @RequestMapping("/common/upload")
    public ResponseData updateFile(MultipartFile file){
        ResponseData data = operateFailed("上传失败！");
        try {
            //获取上传文件路径
            String fielPath = Global.getUploadPath();
            //上传并返回新的文件名称
            String fileName = FileUploadUtils.upload(fielPath,file);
            //获取新的文件路劲
            String url = serverConfig.getUrl() + fileName;
            Map<String,Object> map = new HashMap<>();
            map.put("fileName", fileName);
            map.put("url", url);
            data = operateSucess("上传成功！");
            data.setData(map);
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    /**
     * @method:  getList
     * @description: <p>用户列表数据接口</p>
     * @params:  sysUserInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/12/15 1:25
     * @author: yanakai@126.com
     */
    @RequestMapping("/user/list")
    public TableDataInfo getList(SysUserInfo sysUserInfo){
        startPage();
        List<SysUserInfo> list = sysUserInfoService.getList(sysUserInfo);
        return getDataTable(list);
    }

    /**
     * @method:  tableDataList
     * @description: <p>角色列表数据接口</p>
     * @params:  request
     * @Param sysRoleInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/12/15 1:25
     * @author: yanakai@126.com
     */
    @RequestMapping("/role/list")
    public TableDataInfo tableDataList(HttpServletRequest request, SysRoleInfo sysRoleInfo){
        //执行分页
        startPage();
        List<SysRoleInfo> list = sysRoleInfoService.getList(sysRoleInfo);
        return getDataTable(list);
    }
    /**
     * @method:  articlePage
     * @description: <p>文章列表数据接口</p>
     * @params:  request
     * @Param sysArticleInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/12/15 1:26
     * @author: yanakai@126.com
     */
    @RequestMapping("/article/list")
    public TableDataInfo articlePage(HttpServletRequest request, SysArticleInfo sysArticleInfo){
        //初始化分页
        startPage();
        sysArticleInfo.setDeleteStatus(0);
        List<SysArticleInfo> list = sysArticleInfoService.getList(sysArticleInfo);
        return getDataTable(list);
    }
    @RequestMapping("/article/saveOrUpdate")
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
    @PostMapping("/article/delete/{articleId}")
    public ResponseData virtualDeleteById(HttpServletRequest request,@PathVariable("articleId") Long articleId){
        ResponseData data = operateFailed("操作失败");
        int state = 0;
        SysArticleInfo sysArticleInfo = sysArticleInfoService.getInfoById(articleId);
        sysArticleInfo.setDeleteStatus(1);
        state = sysArticleInfoService.updateNotNull(sysArticleInfo);
        if (state>0) data = operateSucess("操作成功");
        return data;
    }
    /**
     * @method:  columnPage
     * @description: <p>栏目列表数据接口</p>
     * @params:  request
     * @Param sysColumnInfo
     * @return: com.blog.sys.common.base.TableDataInfo
     * @date: 2019/12/15 1:26
     * @author: yanakai@126.com
     */
    @RequestMapping("/column/list")
    public TableDataInfo columnPage(HttpServletRequest request, SysColumnInfo sysColumnInfo){
        startPage();
        List<SysColumnInfo> list = sysColumnInfoService.getList(sysColumnInfo);
        return getDataTable(list);
    }
    @PostMapping("/column/delete/{columnId}")
    public ResponseData deleteById(@PathVariable("columnId")Long columnId){
        ResponseData data = operateFailed("删除失败");
        int state = 0;
        state = sysColumnInfoService.deleteByPrimaryKey(columnId);
        if (state>0){
            data = operateSucess("删除成功");
        }
        return data;
    }
}
