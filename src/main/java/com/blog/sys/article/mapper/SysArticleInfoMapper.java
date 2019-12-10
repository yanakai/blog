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
     * @Title: getArticleListByHotColumn
     * @Description:  获取热点栏目及栏目下文章 每个栏目下文章最多获取7条
     * @Param:
     * @return: java.util.List<com.blog.sys.article.model.SysArticleInfo>
     * @author: yankai
     * @date   2019-12-10
     */
    List<SysArticleInfo> getArticleListByHotColumn();
}