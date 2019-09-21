package com.yk.blog.article.service.impl;

import com.yk.blog.article.mapper.SysArticleInfoMapper;
import com.yk.blog.article.service.ISysArticleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.article.service.impl
 * @ClassName: SysArticleInfoServiceImpl
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/21 22:22
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/21 22:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class SysArticleInfoServiceImpl implements ISysArticleInfoService {
    @Resource
    private SysArticleInfoMapper sysArticleInfoMapper;
}
