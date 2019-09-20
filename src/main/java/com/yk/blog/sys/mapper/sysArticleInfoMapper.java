package com.yk.blog.sys.mapper;

import com.yk.blog.sys.model.sysArticleInfo;

public interface sysArticleInfoMapper {
    int deleteByPrimaryKey(String articleId);

    int insert(sysArticleInfo record);

    int insertSelective(sysArticleInfo record);

    sysArticleInfo selectByPrimaryKey(String articleId);

    int updateByPrimaryKeySelective(sysArticleInfo record);

    int updateByPrimaryKey(sysArticleInfo record);
}