package com.blog.sys.article.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class SysArticleInfo implements Serializable {
    /**
     * 主键id
     */
    private Long articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章摘要
     */
    private String articleAbstract;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 图片名称
     */
    private String imgName;

    /**
     * 图片路径
     */
    private String imgPath;

    /**
     * 浏览次数
     */
    private Integer chickNum;

    /**
     * 点赞次数
     */
    private Integer pointNum;

    /**
     * 所属栏目
     */
    private String columnId;

    /**
     * 所属标签
     */
    private String tagId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 最后一次修改时间
     */
    private Date lastModifyTime;

    /**
     * 最后一次修改人
     */
    private String lastModifyName;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 发布人
     */
    private String releaseName;

    /**
     * 删除状态：0：未删除；1：删除；默认值为0
     */
    private Integer deleteStatus;

    /**
     * 发布状态：0：未发布；1：已发布；默认值为0
     */
    private Integer releaseStatus;

    /**
     * 置顶状态：0：未置顶；1：已置顶；默认为0
     */
    private Integer topStatus;

    private static final long serialVersionUID = 1L;
    
    /**
     * 文章栏目名称 ---只做显示，不做持久化
     */
    private String columnName;

    /**
     * 文章栏目名称 ---只做显示，不做持久化
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 文章栏目名称 ---只做显示，不做持久化
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 主键id
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 主键id
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 文章标题
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * 文章标题
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    /**
     * 文章摘要
     */
    public String getArticleAbstract() {
        return articleAbstract;
    }

    /**
     * 文章摘要
     */
    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract == null ? null : articleAbstract.trim();
    }

    /**
     * 文章内容
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * 文章内容
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    /**
     * 图片名称
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * 图片名称
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * 图片路径
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 图片路径
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    /**
     * 点赞次数
     */
    public Integer getPointNum() {
        return pointNum;
    }

    /**
     * 点赞次数
     */
    public void setPointNum(Integer pointNum) {
        this.pointNum = pointNum;
    }

    /**
     * 浏览次数
     */
    public Integer getChickNum() {
        return chickNum;
    }

    /**
     * 浏览次数
     */
    public void setChickNum(Integer chickNum) {
        this.chickNum = chickNum;
    }

    /**
     * 所属栏目
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * 所属栏目
     */
    public void setColumnId(String columnId) {
        this.columnId = columnId == null ? null : columnId.trim();
    }

    /**
     * 所属标签
     */
    public String getTagId() {
        return tagId;
    }

    /**
     * 所属标签
     */
    public void setTagId(String tagId) {
        this.tagId = tagId == null ? null : tagId.trim();
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 创建人
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 最后一次修改时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 最后一次修改时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 最后一次修改人
     */
    public String getLastModifyName() {
        return lastModifyName;
    }

    /**
     * 最后一次修改人
     */
    public void setLastModifyName(String lastModifyName) {
        this.lastModifyName = lastModifyName == null ? null : lastModifyName.trim();
    }

    /**
     * 发布时间
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * 发布时间
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 发布人
     */
    public String getReleaseName() {
        return releaseName;
    }

    /**
     * 发布人
     */
    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName == null ? null : releaseName.trim();
    }

    /**
     * 删除状态：0：未删除；1：删除；默认值为0
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 删除状态：0：未删除；1：删除；默认值为0
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 发布状态：0：未发布；1：已发布；默认值为0
     */
    public Integer getReleaseStatus() {
        return releaseStatus;
    }

    /**
     * 发布状态：0：未发布；1：已发布；默认值为0
     */
    public void setReleaseStatus(Integer releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    /**
     * 置顶状态：0：未置顶；1：已置顶；默认为0
     */
    public Integer getTopStatus() {
        return topStatus;
    }

    /**
     * 置顶状态：0：未置顶；1：已置顶；默认为0
     */
    public void setTopStatus(Integer topStatus) {
        this.topStatus = topStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleId=").append(articleId);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", articleAbstract=").append(articleAbstract);
        sb.append(", articleContent=").append(articleContent);
        sb.append(", imgName=").append(imgName);
        sb.append(", imgPath=").append(imgPath);
        sb.append(", pointNum=").append(pointNum);
        sb.append(", chickNum=").append(chickNum);
        sb.append(", columnId=").append(columnId);
        sb.append(", tagId=").append(tagId);
        sb.append(", createTime=").append(createTime);
        sb.append(", createName=").append(createName);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", lastModifyName=").append(lastModifyName);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", releaseName=").append(releaseName);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", releaseStatus=").append(releaseStatus);
        sb.append(", topStatus=").append(topStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}