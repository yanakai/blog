package com.yk.blog.article.mapper;

import com.yk.blog.article.model.SysArticleInfo;

public interface SysArticleInfoMapper {
    int deleteByPrimaryKey(String articleId);

    int insert(SysArticleInfo record);

    int insertSelective(SysArticleInfo record);

    SysArticleInfo selectByPrimaryKey(String articleId);

    int updateByPrimaryKeySelective(SysArticleInfo record);

    int updateByPrimaryKey(SysArticleInfo record);
}