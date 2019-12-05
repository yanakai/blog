package com.blog.sys.common.interceptor;

import com.blog.sys.common.annotation.RepeatSubmit;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.json.JSON;
import com.blog.sys.common.utils.ServletUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 防止重复提交拦截器
 *
 */
@Component
public abstract class RepeatSubmitInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            if (annotation != null){
                if (this.isRepeatSubmit(request)) {
                    ResponseData data = new ResponseData(ResponseData.ResponseState.FAILED_STATE,"不允许重复提交，请稍后再试");
                    ServletUtils.renderString(response, JSON.marshal(data));
                    return false;
                }
            }
            return true;
        }else{
            return super.preHandle(request, response, handler);
        }
    }

    /**
     * 验证是否重复提交由子类实现具体的防重复提交的规则
     * 
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    public abstract boolean isRepeatSubmit(HttpServletRequest request) throws Exception;
}
