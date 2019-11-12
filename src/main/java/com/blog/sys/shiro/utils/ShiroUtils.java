package com.blog.sys.shiro.utils;

import com.blog.sys.common.utils.BeanUtils;
import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.shiro.realm.UserRealm;
import com.blog.sys.user.model.SysUserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * 
  * <p>Title: ShiroUtils</p>  
  * <p>Description: shiro工具类</p>  
  * @author yanakai@126.com  
  * @date 2019年7月3日
 */
public class ShiroUtils {

	/**
	 * 
	 * <p>Title: getSubject</p>  
	 * <p>Description: 获取Subject</p> 
	 * @return  
	 * @author yanakai@126.com
	 * @date 2019年7月3日
	 */
	public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

	/**
	 * 
	 * <p>Title: getSession</p>  
	 * <p>Description: 获取Subject的session对象</p> 
	 * @return  
	 * @author yanakai@126.com
	 * @date 2019年7月3日
	 */
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 
     * <p>Title: logout</p>  
     * <p>Description: 清除subject</p>   
     * @author yanakai@126.com
     * @date 2019年7月3日
     */
    public static void logout(){
        getSubject().logout();
    }
    
    /**
     * 
     * <p>Title: getSysUser</p>  
     * <p>Description: 获取当前登录者对象</p> 
     * @return  
     * @author yanakai@126.com
     * @date 2019年7月3日
     */
    public static SysUserInfo getSysUser(){
    	SysUserInfo user = null;
        Object obj = getSubject().getPrincipal();
        if (StringUtils.isNotNull(obj)){
            user = new SysUserInfo();
            BeanUtils.copyBeanProp(user, obj);
        }
        return user;
    }
    
    /**
     * 
     * <p>Title: setSysUser</p>  
     * <p>Description: 当前登录者放入subject</p> 
     * @param user  当前登录者对象
     * @author yanakai@126.com
     * @date 2019年7月3日
     */
    public static void setSysUser(SysUserInfo user){
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }
    
    /**
     * 
     * <p>Title: clearCachedAuthorizationInfo</p>  
     * <p>Description: 清除当前登录者缓存权限</p>   
     * @author yanakai@126.com
     * @date 2019年7月3日
     */
    public static void clearCachedAuthorizationInfo(){
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm realm = (UserRealm) rsm.getRealms().iterator().next();
        realm.clearCachedAuthorizationInfo();
    }
    
    /**
     * 
     * <p>Title: getUserId</p>  
     * <p>Description: 获取当前登录者的id</p> 
     * @return  
     * @author yanakai@126.com
     * @date 2019年7月3日
     */
    public static String getUserId(){
        return getSysUser().getUserId();
    }
    
    /**
     * 
     * <p>Title: getLoginName</p>  
     * <p>Description: 获取当前登陆者用户名</p> 
     * @return  
     * @author yanakai@126.com
     * @date 2019年7月3日
     */
    public static String getUserName(){
        return getSysUser().getUserName();
    }

    /**
     * 
     * <p>Title: getIp</p>  
     * <p>Description: 获取当前登录者的ip</p> 
     * @return  
     * @author yanakai@126.com
     * @date 2019年7月3日
     */
    public static String getIp(){
        return getSubject().getSession().getHost();
    }

    /**
     * 
     * <p>Title: getSessionId</p>  
     * <p>Description: 获取当前sessionId</p> 
     * @return  
     * @author yanakai@126.com
     * @date 2019年7月3日
     */
    public static String getSessionId(){
        return String.valueOf(getSubject().getSession().getId());
    }
    
    /**
     * 
     * <p>Title: randomSalt</p>  
     * <p>Description: 生成登录者随机盐</p> 
     * @return  
     * @author yanakai@126.com
     * @date 2019年7月3日
     */
    public static String randomSalt(){
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }
}
