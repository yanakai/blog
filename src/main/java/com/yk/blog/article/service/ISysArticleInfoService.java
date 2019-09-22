package com.yk.blog.article.service;

import com.yk.blog.article.model.SysArticleInfo;

import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.article.service
 * @ClassName: ISysArticleInfoService
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/21 22:22
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/21 22:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysArticleInfoService {
    /**
     * @method  getList
     * @description <p>通过对象获取列表数据</p>
     * @date: 2019/9/21 23:32
     * @author: yanakai@126.com
     * @params  [sysArticleInfo] 文章对象信息
     * @return java.util.List<com.yk.blog.article.model.SysArticleInfo>
     */
    List<SysArticleInfo> getList(SysArticleInfo sysArticleInfo);

    /**
     * @method:  updateNotNull
     * @description: <p>根据主键修改不为空的数据</p>
     * @params:  [sysArticleInfo]
     * @return int
     * @date: 2019/9/22 23:24
     * @author: yanakai@126.com
     */
    int updateNotNull(SysArticleInfo sysArticleInfo);

    /**
     * @method:  getInfoById
     * @description: <p>主键查询对象</p>
     * @params:  [id]
     * @return com.yk.blog.article.model.SysArticleInfo
     * @date: 2019/9/23 0:25
     * @author: yanakai@126.com
     */
    SysArticleInfo getInfoById(String id);
}
