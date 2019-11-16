package com.blog.sys.common.config;

import com.blog.sys.common.utils.StringUtils;
import com.blog.sys.common.utils.YamlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @ProjectName:    blog
 * @Package:        com.yk.blog.common.config
 * @ClassName:      Global
 * @Description:    全局配置类
 * @Author:         yanakai@126.com
 * @CreateDate:     2019/9/26 23:18
 * @UpdateUser:     yanakai@126.com
 * @UpdateDate:     2019/9/26 23:18
 * @UpdateRemark:   更新内容
 * @Version:        1.0
 */
@Component
@ConfigurationProperties(prefix = "blog")
public class Global{
    private static final Logger log = LoggerFactory.getLogger(Global.class);

    private static String NAME = "application.yml";

    /**
     * 当前对象实例
     */
    private static Global global;

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = new HashMap<String, String>();

    private Global(){
    }

    /**
     * 静态工厂方法
     */
    public static synchronized Global getInstance(){
        if (global == null){
            global = new Global();
        }
        return global;
    }

    /**
     * 获取配置
     */
    public static String getConfig(String key){
        String value = map.get(key);
        if (value == null){
            Map<?, ?> yamlMap = null;
            try{
                yamlMap = YamlUtil.loadYaml(NAME);
                value = String.valueOf(YamlUtil.getProperty(yamlMap, key));
                map.put(key, value != null ? value : StringUtils.EMPTY);
            }catch (FileNotFoundException e){
                log.error("获取全局配置异常 {}", key);
            }
        }
        return value;
    }

    /**
     * 获取项目名称
     */
    public static String getName(){
        return StringUtils.nvl(getConfig("yk.name"), "blog");
    }

    /**
     * 获取项目版本
     */
    public static String getVersion(){
        return StringUtils.nvl(getConfig("yk.version"), "1.0");
    }

    /**
     * 获取版权年份
     */
    public static String getCopyrightYear(){
        return StringUtils.nvl(getConfig("yk.copyrightYear"), "2019");
    }

    /**
     * 获取ip地址开关
     */
    public static Boolean isAddressEnabled(){
        return Boolean.valueOf(getConfig("yk.addressEnabled"));
    }

    /**
     * 获取文件上传路径
     */
    public static String getProfile(){
        return getConfig("blog.profile");
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath(){
        return getProfile() + "/avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath(){
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath(){
        return getProfile() + "/upload";
    }
}
