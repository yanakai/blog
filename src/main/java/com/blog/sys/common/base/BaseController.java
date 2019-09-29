package com.blog.sys.common.base;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.common.base
 * @ClassName: BaseController
 * @Description: web层通用数据处理
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/21 22:19
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/21 22:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BaseController {

    /**
     * @method  initBinder
     * @description <p>将前台传递过来的日期格式的字符串，自动转化为Date类型。防止ajax序列化提交数据无法传到后台</p>
     * @date: 2019/9/21 22:30
     * @author: yanakai@126.com
     * @params  [binder]
     * @return void
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport(){
            @Override
            public void setAsText(String text){
                setValue(DateUtil.parseDate(text));
            }
        });
    }



    /**
     * 设置请求分页数据
     */
    protected void startPage(){
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (pageNum !=null && pageSize !=null){
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }



    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list){
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     *
     * <p>
     * <b>方法描述：</b>操作成功默认提示
     * </p>
     *
     * @return 输出信息的对象
     */
    protected ResponseData operateSucess() {
        return operateSucess("操作成功！");
    }

    /**
     *
     * <p>
     * <b>方法描述：</b>自定义操作成功提示信息
     * </p>
     *
     * @param msg
     *            成功时的信息
     * @return 输出信息的对象
     */
    protected ResponseData operateSucess(String msg) {
        ResponseData result = new ResponseData(ResponseData.ResponseState.SUCESS_STATE);
        result.setMsg(msg);
        return result;
    }

    /**
     *
     * <p>
     * <b>方法描述：</b>自定义操作成功提示信息，并返回数据
     * </p>
     *
     * @param msg
     *            成功时的信息
     * @param data
     *            数据对象
     * @return 输出信息的对象
     */
    protected ResponseData operateSucess(String msg, Object data) {
        ResponseData result = operateSucess(msg);
        result.setData(data);
        return result;
    }

    /***
     * <p><b>方法描述：</b>自定义操作成功提示信息，并返回数据和code</p>
     * @param msg 成功时的信息
     * @param data 数据对象
     * @param code code编码
     * @return ResponseData
     */
    protected ResponseData operateSucess(String msg, Object data, String code) {
        ResponseData result = operateSucess(msg, data);
        result.setCode(code);
        return result;
    }

    /**
     *
     * <p>
     * <b>方法描述：</b>自定义失败提示信息
     * </p>
     *
     * @param msg 失败时的信息
     * @return 输出信息的对象
     */
    protected ResponseData operateFailed(String msg) {
        ResponseData result = new ResponseData(ResponseData.ResponseState.FAILED_STATE);
        result.setMsg(msg);
        return result;
    }

    /**
     *
     * <p>
     * <b>方法描述：</b>自定义失败提示信息并返回数据
     * </p>
     *
     * @param msg 失败时的信息
     * @param data 数据对象
     * @return 输出信息的对象
     */
    protected ResponseData operateFailed(String msg, Object data) {
        ResponseData result = operateFailed(msg);
        result.setData(data);
        return result;
    }

    /***
     * <p><b>方法描述：</b>自定义失败提示信息并返回数据和code</p>
     * @param msg 失败时的信息
     * @param data 数据对象
     * @param code code编码
     * @return ResponseData
     */
    protected ResponseData operateFailed(String msg, Object data, String code) {
        ResponseData result = operateFailed(msg, data);
        result.setCode(code);
        return result;
    }


}
