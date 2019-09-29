package com.blog.sys.column.service.impl;

import cn.hutool.core.util.StrUtil;
import com.blog.sys.column.mapper.SysColumnInfoMapper;
import com.blog.sys.column.model.SysColumnInfo;
import com.blog.sys.column.service.ISysColumnInfoService;
import com.blog.sys.common.utils.UserConstants;
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

    @Override
    public String checkColumnNameUnique(SysColumnInfo sysColumnInfo) {
        String columnId = StrUtil.isEmpty(sysColumnInfo.getColumnId())?"":sysColumnInfo.getColumnId();
       SysColumnInfo temp = sysColumnInfoMapper.checkColumnNameUnique(sysColumnInfo.getColumnName());
        if (temp != null && !columnId.equals(temp.getColumnId())){
            return UserConstants.USER_COLUMN_NAME_NOT_UNIQUE;
        }
        return  UserConstants.USER_COLUMN_NAME_UNIQUE;
    }
}
