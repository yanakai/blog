package com.blog.sys.shiro.realm;

import com.blog.sys.menu.service.ISysMenuInfoService;
import com.blog.sys.role.service.ISysRoleInfoService;
import com.blog.sys.shiro.utils.ShiroUtils;
import com.blog.sys.user.model.SysUserInfo;
import com.blog.sys.user.service.ISysUserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.shiro.realm
 * @ClassName: UserRealm
 * @Description: java类作用描述
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/12 22:44
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/12 22:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private ISysUserInfoService sysUserInfoService;
    @Resource
    private ISysRoleInfoService sysRoleInfoService;
    @Resource
    private ISysMenuInfoService sysMenuInfoService;

    //授权方法   用户权限查询
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取当前登录用户
        SysUserInfo sysUserInfo= ShiroUtils.getSysUser();
        //角色集合
        Set<String> roleSet=new HashSet<>();
        //功能集合
        Set<String> menuSet=new HashSet<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 根据用户id查询当前用户的权限
        if("admin".equals(sysUserInfo.getUserName())){
            //判断当前登陆者是否是超级管理员即admin用户
            //超级管理员有所有权限
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        }else{
            roleSet=sysRoleInfoService.getRoleKeysByUserId(sysUserInfo.getUserId());
            menuSet=sysMenuInfoService.getMenuPermsByUserId(sysUserInfo.getUserId());
            info.setRoles(roleSet);
            info.setStringPermissions(menuSet);
        }
        return info;
    }

    //认证方法  登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        // 获取登录的用户名
        String userName = usernamePasswordToken.getUsername();
        // 从数据库中查询用户  在此可判断登录状态用户名和密码
        SysUserInfo sysUserInfo  = sysUserInfoService.findByUserName(userName);
        return new SimpleAuthenticationInfo(sysUserInfo, sysUserInfo.getPassword(), this.getClass().getName());
    }

    /**
     * @method:  clearCachedAuthorizationInfo
     * @description: <p>清理缓存权限</p>
     * @params:
     * @return: void
     * @date: 2019/11/12 23:06
     * @author: yanakai@126.com
     */
    public void clearCachedAuthorizationInfo(){
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

}
