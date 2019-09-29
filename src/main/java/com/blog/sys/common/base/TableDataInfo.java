package com.blog.sys.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.common.base
 * @ClassName: TableDataInfo
 * @Description: 页面表格分页数据对象
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/21 22:40
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/21 22:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 总记录数 */
    private long total;
    /** 列表数据 */
    private List<?> rows;
    /** 消息状态码 */
    private int code;

    /**
     * 表格数据对象
     */
    public TableDataInfo(){}

    /**
     * 分页
     *
     * @param list 列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, int total){
        this.rows = list;
        this.total = total;
    }

    public long getTotal(){
        return total;
    }

    public void setTotal(long total){
        this.total = total;
    }

    public List<?> getRows(){
        return rows;
    }

    public void setRows(List<?> rows){
        this.rows = rows;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }
}

