package com.yk.blog.article.mapper;

import com.yk.blog.article.model.sysArticleInfo;

public interface sysArticleInfoMapper {
    int deleteByPrimaryKey(String articleId);

    int insert(sysArticleInfo record);

    int insertSelective(sysArticleInfo record);

    sysArticleInfo selectByPrimaryKey(String articleId);

    int updateByPrimaryKeySelective(sysArticleInfo record);

    int updateByPrimaryKey(sysArticleInfo record);
}