package com.blog.sys.common.base.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 基类，封装公共查询字段
 * @author: yankai
 * @date   2019-11-21
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 请求参数 */
    private Map<String, Object> params;

    /** 请求参数 */
    public Map<String, Object> getParams() {
        return params;
    }
    /**
     * 请求参数
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
