package com.blog.sys.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 程序注解配置
 *
 */
@Configuration
// 指定要扫描的Mapper类的包的路径
@MapperScan(value = "com.blog.sys.*.mapper")
public class ApplicationConfig
{

}