package com.yk.blog.column.service;

import com.yk.blog.column.model.SysColumnInfo;

import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.column.service
 * @ClassName: ISysColumnInfoService
 * @Description: 文章栏目业务层接口
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/23 22:06
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/23 22:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysColumnInfoService {
    /**
     * @method:  getList
     * @description: <p>通过查列表</p>
     * @params:  [sysColumnInfo]
     * @return java.util.List<com.yk.blog.column.model.SysColumnInfo>
     * @date: 2019/9/23 22:12
     * @author: yanakai@126.com
     */
    List<SysColumnInfo> getList(SysColumnInfo sysColumnInfo);

    /**
     * @method:  saveNotNUll
     * @description: <p> 保存不为空的数据</p>
     * @params:  [sysColumnInfo]
     * @return int
     * @date: 2019/9/23 22:45
     * @author: yanakai@126.com
     */
    int saveNotNUll(SysColumnInfo sysColumnInfo);

    /**
     * @method:  updateNotNUll
     * @description: <p>通过主键id修改不为空的数据</p>
     * @params:  [sysColumnInfo]
     * @return int
     * @date: 2019/9/23 22:47
     * @author: yanakai@126.com
     */
    int updateNotNUll(SysColumnInfo sysColumnInfo);

    /**
     * @method:  selectByPrimaryKey
     * @description: <p>通过主键查询数据对象</p>
     * @params:  [columnId]
     * @return com.yk.blog.column.model.SysColumnInfo
     * @date: 2019/9/23 22:52
     * @author: yanakai@126.com
     */
    SysColumnInfo selectByPrimaryKey(String columnId);

    /**
     * @method:  deleteByPrimaryKey
     * @description: <p>通过主键删除对象</p>
     * @params:  [columnId]
     * @return int
     * @date: 2019/9/23 22:55
     * @author: yanakai@126.com
     */
    int deleteByPrimaryKey(String columnId);

    /**
     * @method:  checkColumnNameUnique
     * @description: <p>校验栏目名称是否已存在</p>
     * @params:  [sysColumnInfo]
     * @return java.lang.String
     * @date: 2019/9/23 23:19
     * @author: yanakai@126.com
     */
    String checkColumnNameUnique(SysColumnInfo sysColumnInfo);
}
