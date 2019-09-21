package com.yk.blog.common.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.common.base
 * @ClassName: ResponseData
 * @Description: 页面响应数据对象
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/21 22:33
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/21 22:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseData implements Serializable {

    /**
     * 信息状态：1：成功；0：失败
     *
     */
    private Integer state;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 返回的对象
     */
    private Object data;

    /**
     * 信息代码
     */
    private String code;

    /***
     *
     *
     */
    public ResponseData() {

    }

    /***
     *
     * @param resState
     *            信息状态
     */
    public ResponseData(ResponseState resState) {
        this.state = resState.state;
    }

    /**
     *
     * @param state
     *            信息状态
     * @param message
     *            描述信息
     */
    public ResponseData(ResponseState state, String message) {
        this(state);
        this.message = message;
    }

    /**
     *
     * @param code 状态码
     * @param state 操作状态 0失败 1成功
     * @param message 提示信息
     */
    public ResponseData(String code, ResponseState state, String message) {
        this(state);
        this.code = code;
        this.message = message;
    }

    /***
     *
     * @param state
     *            信息状态
     * @param message
     *            描述信息
     * @param data
     *            返回的对象
     */
    public ResponseData(ResponseState state, String message, Object data) {
        this(state, message);
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 返回状态枚举
     * 类描述：记录信息返回的状态
     * @author yK
     * 2018年1月9日
     */
    public enum ResponseState {
        /***
         * SUCESS_STATE 成功
         */
        SUCESS_STATE(1),
        /**
         * FAILED_STATE 失败
         */
        FAILED_STATE(0);
        /***
         * 状态信息
         */
        private Integer state;

        ResponseState(Integer state) {
            this.state = state;
        }

        public Integer getValue() {
            return this.state;
        }

    }

}
