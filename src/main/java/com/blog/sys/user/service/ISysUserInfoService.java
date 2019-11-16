package com.blog.sys.user.service;

import com.blog.sys.user.model.SysUserInfo;

import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.user.service.ISysUserInfoService
 * @ClassName: ISysUserInfoService
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/4 22:27
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/4 22:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ISysUserInfoService {
    /**
     * @method:  getList
     * @description: <p>获取用户列表数据</p>
     * @params:  sysUserInfo
     * @return: java.util.List<com.blog.sys.user.model.SysUserInfo>
     * @date: 2019/11/6 21:29
     * @author: yanakai@126.com
     */
    List<SysUserInfo> getList(SysUserInfo sysUserInfo);

    /**
     * @method:  getById
     * @description: <p>通过主键查询用户信息</p>
     * @params:  userId
     * @return: com.blog.sys.user.model.SysUserInfo
     * @date: 2019/11/7 21:33
     * @author: yanakai@126.com
     */
    SysUserInfo getById(String userId);

    /**
     * @method:  updateNotNull
     * @description: <p>修改不为空的数据</p>
     * @params:  sysUserInfo
     * @return: int
     * @date: 2019/11/7 21:41
     * @author: yanakai@126.com
     */
    int updateNotNull(SysUserInfo sysUserInfo);

    /**
     * @method:  saveNotNull
     * @description: <p>保存不为空的数据</p>
     * @params:  sysUserInfo
     * @return: int
     * @date: 2019/11/7 21:44
     * @author: yanakai@126.com
     */
    int saveNotNull(SysUserInfo sysUserInfo);

    /**
     * @method:  deleteById
     * @description: <p>通过主键删除</p>
     * @params:  userId 用户id
     * @return: int
     * @date: 2019/11/7 21:48
     * @author: yanakai@126.com
     */
    int deleteById(String userId);

    /**
     * @method:  checkUserNameUnique
     * @description: <p>验证用户名是否已存在</p>
     * @params:  sysUserInfo
     * @return: java.lang.String
     * @date: 2019/11/8 21:16
     * @author: yanakai@126.com
     */
    String checkUserNameUnique(SysUserInfo sysUserInfo);

    /**
     * @method:  checkPhoneUnique
     * @description: <p>验证手机号是否已存在</p>
     * @params:  sysUserInfo
     * @return: java.lang.String
     * @date: 2019/11/8 21:33
     * @author: yanakai@126.com
     */
    String checkPhoneUnique(SysUserInfo sysUserInfo);

    /**
     * @method:  checkEmailUnique
     * @description: <p>验证email是否已存在</p>
     * @params:  sysUserInfo
     * @return: java.lang.String
     * @date: 2019/11/8 21:33
     * @author: yanakai@126.com
     */
    String checkEmailUnique(SysUserInfo sysUserInfo);

    /**
     * @method:  allocatedList
     * @description: <p>获取角色下用户列表数据</p>
     * @params:  sysUserInfo
     * @return: java.util.List<com.blog.sys.user.model.SysUserInfo>
     * @date: 2019/11/9 18:07
     * @author: yanakai@126.com
     */
    List<SysUserInfo> allocatedList(SysUserInfo sysUserInfo);

    /**
     * @method:  selectUnallocatedList
     * @description: <p>获取不在某个角色下的所有用户列表</p>
     * @params:  sysUserInfo
     * @return: java.util.List<com.blog.sys.user.model.SysUserInfo>
     * @date: 2019/11/10 14:04
     * @author: yanakai@126.com
     */
    List<SysUserInfo> selectUnallocatedList(SysUserInfo sysUserInfo);

    /**
     * @method:  findByUserName
     * @description: <p>通过用户名查询用户信息</p>
     * @params:  userName
     * @return: com.blog.sys.user.model.SysUserInfo
     * @date: 2019/11/12 22:50
     * @author: yanakai@126.com
     */
    SysUserInfo findByUserName(String userName);

    /**
     * @method:  selectUserByPhoneNumber
     * @description: <p>通过手机号查询用户信息</p>
     * @params:  phoneNumber
     * @return: com.blog.sys.user.model.SysUserInfo
     * @date: 2019/11/16 15:52
     * @author: yanakai@126.com
     */
    SysUserInfo selectUserByPhoneNumber(String phoneNumber);

    /**
     * @method:  selectUserByEmail
     * @description: <p>通过Email查询用户信息</p>
     * @params:  email
     * @return: com.blog.sys.user.model.SysUserInfo
     * @date: 2019/11/16 15:52
     * @author: yanakai@126.com
     */
    SysUserInfo selectUserByEmail(String email);
}
