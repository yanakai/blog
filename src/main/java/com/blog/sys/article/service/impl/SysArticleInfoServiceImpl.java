package com.blog.sys.article.service.impl;

import com.blog.sys.article.mapper.SysArticleInfoMapper;
import com.blog.sys.article.model.SysArticleInfo;
import com.blog.sys.article.service.ISysArticleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<SysArticleInfo> getList(SysArticleInfo sysArticleInfo) {
        return sysArticleInfoMapper.getList(sysArticleInfo);
    }

    @Override
    public int updateNotNull(SysArticleInfo sysArticleInfo) {
        return sysArticleInfoMapper.updateByPrimaryKeySelective(sysArticleInfo);
    }

    @Override
    public SysArticleInfo getInfoById(Long id) {
        return sysArticleInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveNotNull(SysArticleInfo sysArticleInfo) {
        return sysArticleInfoMapper.insertSelective(sysArticleInfo);
    }

    @Override
    public Map<String, List<SysArticleInfo>> getArticleListByHotColumn() {
        List<SysArticleInfo> list = sysArticleInfoMapper.getArticleListByHotColumn();
        Map<String, List<SysArticleInfo>> map = new HashMap<>();
        for (SysArticleInfo info : list){
            //判断map的key是否包含某个栏目的值不包含则把新的栏目值放入map里面
            if (map.containsKey(info.getColumnName())){
                map.get(info.getColumnName()).add(info);
            }else {
                List<SysArticleInfo> infoList = new ArrayList<>();
                infoList.add(info);
                map.put(info.getColumnName(),infoList);
            }
        }
        return map;
    }
}
