package com.yk.blog.common.config;

import com.yk.blog.common.utils.ServletUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @ProjectName:    blog
 * @Package:        com.yk.blog.common.config
 * @ClassName:      ServerConfig
 * @Description:    项目服务相关配置
 * @Author:         yanakai@126.com
 * @CreateDate:     2019/9/26 23:33
 * @UpdateUser:     yanakai@126.com
 * @UpdateDate:     2019/9/26 23:33
 * @UpdateRemark:   更新内容
 * @Version:        1.0
 */

@Component
public class ServerConfig {
    /**
     * 获取完整的请求路径，包括：域名，端口，上下文访问路径
     * 
     * @return 服务地址
     */
    public String getUrl(){
        HttpServletRequest request = ServletUtils.getRequest();
        return getDomain(request);
    }

    public static String getDomain(HttpServletRequest request){
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
    }
}
