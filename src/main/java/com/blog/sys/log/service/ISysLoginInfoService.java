package com.blog.sys.log.service;

import com.blog.sys.log.model.SysLoginInfo;

import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.log.service
 * @ClassName: ISysLoginInfoService
 * @Description: 登录日志service层接口
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/20 22:10
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/20 22:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysLoginInfoService {
    /**
     * @method:  getList
     * @description: <p>登录日志获取列表数据</p>
     * @params:  sysLoginInfo
     * @return: java.util.List<com.blog.sys.log.model.SysLoginInfo>
     * @date: 2019/11/20 22:30
     * @author: yanakai@126.com
     */
    List<SysLoginInfo> getList(SysLoginInfo sysLoginInfo);

    /**
     * @method:  cleanLoginInfo
     * @description: <p>清空登录日志</p>
     * @params:
     * @return: int
     * @date: 2019/11/20 22:58
     * @author: yanakai@126.com
     */
    int cleanLoginInfo();

    /**
     * @method:  saveLoginInfo
     * @description: <p>保存数据</p>
     * @params:  sysLoginInfo
     * @return: int
     * @date: 2019/11/21 21:27
     * @author: yanakai@126.com
     */
    int saveLoginInfo(SysLoginInfo sysLoginInfo);
}
