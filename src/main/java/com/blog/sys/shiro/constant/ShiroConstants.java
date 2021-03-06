package com.blog.sys.shiro.constant;

/**
 * @ProjectName: blog
 * @Package: com.blog.sys.shiro.constant
 * @ClassName: ShiroConstants
 * @Description: Shiro通用常量
 * @Author: yanakai@126.com
 * @CreateDate: 2019/11/13 22:55
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/11/13 22:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ShiroConstants {

    /**
     * 当前登录的用户
     */
    public static final String CURRENT_USER = "currentUser";

    /**
     * 用户名
     */
    public static final String CURRENT_USERNAME = "username";

    /**
     * 消息key
     */
    public static String MESSAGE = "message";

    /**
     * 错误key
     */
    public static String ERROR = "errorMsg";

    /**
     * 编码格式
     */
    public static String ENCODING = "UTF-8";

    /**
     * 当前在线会话
     */
    public static final String ONLINE_SESSION = "online_session";

    /**
     * 验证码key
     */
    public static final String CURRENT_CAPTCHA = "captcha";

    /**
     * 验证码开关
     */
    public static final String CURRENT_ENABLED = "captchaEnabled";

    /**
     * 验证码类型
     */
    public static final String CURRENT_TYPE = "captchaType";

    /**
     * 验证码
     */
    public static final String CURRENT_VALIDATECODE = "validateCode";

    /**
     * 验证码错误
     */
    public static final String CAPTCHA_ERROR = "captchaError";

    /**
     * 登录记录缓存
     */
    public static final String LOGINRECORDCACHE = "loginRecordCache";

    /**
     * 系统活跃用户缓存
     */
    public static final String SYS_USERCACHE = "sys-userCache";
}
