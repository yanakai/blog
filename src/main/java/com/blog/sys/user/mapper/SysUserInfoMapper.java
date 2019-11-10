package com.blog.sys.user.mapper;

import com.blog.sys.user.model.SysUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);

    /**
     * @method:  getList
     * @description: <p>获取用户列表信息</p>
     * @params:  sysUserInfo
     * @return: java.util.List<com.blog.sys.user.model.SysUserInfo>
     * @date: 2019/11/6 21:31
     * @author: yanakai@126.com
     */
    List<SysUserInfo> getList(@Param("vo") SysUserInfo sysUserInfo);

    /**
     * @method:  checkUserNameUnique
     * @description: <p>验证用户名是否已存在</p>
     * @params:  userName 用户名
     * @return: int
     * @date: 2019/11/8 21:23
     * @author: yanakai@126.com
     */
    int checkUserNameUnique(String userName);
    /**
     * @method:  checkPhoneUnique
     * @description: <p>验证手机号是否已存在</p>
     * @params:  phoneNumber 手机号
     * @return: SysUserInfo
     * @date: 2019/11/8 21:29
     * @author: yanakai@126.com
     */
    SysUserInfo checkPhoneUnique(String phoneNumber);
    /**
     * @method:  checkEmailUnique
     * @description: <p>验证email是否已存在</p>
     * @params:  email 邮箱
     * @return: SysUserInfo
     * @date: 2019/11/8 21:30
     * @author: yanakai@126.com
     */
    SysUserInfo checkEmailUnique(String email);

    /**
     * @method:  allocatedList
     * @description: <p>获取角色下用户列表数据</p>
     * @params:  sysUserInfo
     * @return: java.util.List<com.blog.sys.user.model.SysUserInfo>
     * @date: 2019/11/9 18:08
     * @author: yanakai@126.com
     */
    List<SysUserInfo> allocatedList(@Param("vo")SysUserInfo sysUserInfo);

    /**
     * @method:  selectUnallocatedList
     * @description: <p>获取不在某个角色下的所有用户列表</p>
     * @params:  sysUserInfo
     * @return: java.util.List<com.blog.sys.user.model.SysUserInfo>
     * @date: 2019/11/10 14:05
     * @author: yanakai@126.com
     */
    List<SysUserInfo> selectUnallocatedList(@Param("vo")SysUserInfo sysUserInfo);
}