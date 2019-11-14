package com.blog.sys.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import com.blog.sys.shiro.realm.CredentialMatcher;
import com.blog.sys.shiro.realm.UserRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.shiro.config
 * @ClassName: ShiroConfig
 * @Description: Shiro配置类
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/12 22:49
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/12 22:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
public class ShiroConfig {

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        // 登录的url
        bean.setLoginUrl("/login");
        // 登录成功后跳转的url
        bean.setSuccessUrl("/index");
        // 权限拒绝时跳转的url
        bean.setUnauthorizedUrl("/unauthorize");
        // Shiro连接约束配置，即过滤链的定义
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 对静态资源设置匿名访问
        filterChainDefinitionMap.put("/favicon.ico**", "anon");
        filterChainDefinitionMap.put("/VBlog.png**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/ajax/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/blog/**", "anon");
        // 不需要拦截就能访问
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/**/api/**", "anon");
        // 指定admin接口只允许admin角色的用户访问
        filterChainDefinitionMap.put("/admin", "roles[admin]");
        // 所有请求需要认证
        filterChainDefinitionMap.put("/**", "user");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
        // 设置自定义的SecurityManager
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }
    //登录对象引入密码校验对象里面
    @Bean("userRealm")
    public UserRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher matcher) {
        // 设置自定义的Realm
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher() {
        // 设置自定义密码校验规则
        return new CredentialMatcher();
    }

    // =========== spring 与 shiro 关联的相关配置 ============
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        // 设置spring在对shiro进行处理的时候，使用的SecurityManager为我们自定义的SecurityManager
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        // 设置代理类
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
}
