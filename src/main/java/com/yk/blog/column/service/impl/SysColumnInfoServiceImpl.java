package com.yk.blog.column.service.impl;

import com.yk.blog.column.mapper.SysColumnInfoMapper;
import com.yk.blog.column.model.SysColumnInfo;
import com.yk.blog.column.service.ISysColumnInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.column.service.impl
 * @ClassName: SysColumnInfoServiceImpl
 * @Description: 文章栏目实现类
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/23 22:07
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/23 22:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class SysColumnInfoServiceImpl implements ISysColumnInfoService {
    @Resource
    private SysColumnInfoMapper sysColumnInfoMapper;

    @Override
    public List<SysColumnInfo> getList(SysColumnInfo sysColumnInfo) {
        return sysColumnInfoMapper.getList(sysColumnInfo);
    }

    @Override
    public int saveNotNUll(SysColumnInfo sysColumnInfo) {
        return sysColumnInfoMapper.insertSelective(sysColumnInfo);
    }

    @Override
    public int updateNotNUll(SysColumnInfo sysColumnInfo) {
        return sysColumnInfoMapper.updateByPrimaryKeySelective(sysColumnInfo);
    }

    @Override
    public SysColumnInfo selectByPrimaryKey(String columnId) {
        return sysColumnInfoMapper.selectByPrimaryKey(columnId);
    }

    @Override
    public int deleteByPrimaryKey(String columnId) {
        return sysColumnInfoMapper.deleteByPrimaryKey(columnId);
    }
}
