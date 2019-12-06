package com.blog.sys.article.mapper;

import com.blog.sys.article.model.SysArticleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysArticleInfoMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(SysArticleInfo record);

    int insertSelective(SysArticleInfo record);

    SysArticleInfo selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(SysArticleInfo record);

    int updateByPrimaryKey(SysArticleInfo record);

    /**
     * @method:  getList
     * @description: <p>通过对象获取列表数据</p>
     * @params:  [sysArticleInfo]文章对象信息
     * @return java.util.List<com.yk.blog.article.model.SysArticleInfo>
     * @date: 2019/9/21 23:36
     * @author: yanakai@126.com
     */
    List<SysArticleInfo> getList(@Param("vo") SysArticleInfo sysArticleInfo);

    /**
     * @Title: getHotArticleList
     * @Description:  查询热点文章，根据点赞数量倒叙 发布时间排序
     * @Param: sysArticleInfo
     * @return: java.util.List<com.blog.sys.article.model.SysArticleInfo>
     * @author: yankai
     * @date   2019/10/9
     */
    List<SysArticleInfo> getHotArticleList(@Param("vo")SysArticleInfo sysArticleInfo);

    /**
     * @Title: getTopArticleList
     * @Description: 获取置顶文章 根据发布时间排序
     * @Param: sysArticleInfo
     * @return: java.util.List<com.blog.sys.article.model.SysArticleInfo>
     * @author: yankai
     * @date   2019/10/9
     */
    List<SysArticleInfo> getTopArticleList(@Param("vo")SysArticleInfo sysArticleInfo);
}