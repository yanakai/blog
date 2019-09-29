package com.yk.blog.common.config;

import com.yk.blog.common.utils.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @ProjectName:    blog
 * @Package:        com.yk.blog.common.config
 * @ClassName:      ResourcesConfig
 * @Description:    项目通用配置
 * @Author:         yanakai@126.com
 * @CreateDate:     2019/9/29 23:17
 * @UpdateUser:     yanakai@126.com
 * @UpdateDate:     2019/9/29 23:17
 * @UpdateRemark:   更新内容
 * @Version:        1.0
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer{


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        /** 本地文件上传路径 图片虚拟路径*/
        registry.addResourceHandler(Constants.RESOURCE_PREFIX + "/**").addResourceLocations("file:" + Global.getProfile() + "/");

    }

}