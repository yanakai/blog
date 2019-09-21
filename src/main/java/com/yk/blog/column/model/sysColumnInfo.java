package com.yk.blog.column.model;

import java.io.Serializable;

/**
 * 
 */
public class sysColumnInfo implements Serializable {
    /**
     * 主键Id
     */
    private String columnId;

    /**
     * 栏目名称
     */
    private String columnName;

    /**
     * 排序码
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * 主键Id
     */
    public void setColumnId(String columnId) {
        this.columnId = columnId == null ? null : columnId.trim();
    }

    /**
     * 栏目名称
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 栏目名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 排序码
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序码
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", columnId=").append(columnId);
        sb.append(", columnName=").append(columnName);
        sb.append(", sort=").append(sort);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}