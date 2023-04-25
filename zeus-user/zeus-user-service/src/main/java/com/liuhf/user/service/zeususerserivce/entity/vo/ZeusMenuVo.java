package com.liuhf.user.service.zeususerserivce.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 菜单展示实体
 */
public class ZeusMenuVo {
    /**
     * 菜单主键
     */
    private Integer id;

    /**
     * 菜单代码
     */
    private String menuCode;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 菜单图标
     */
    private Integer menuIcon;

    /**
     * 前端主键
     */
    private String component;

    /**
     * 前端请求路径
     */
    private String leadPath;

    /**
     * 后端请求路径
     */
    private String backPath;

    /**
     * 重定向地址
     */
    private String redirectPath;

    /**
     * 菜单类型，0菜单，1按钮
     */
    private Integer type;

    /**
     * 菜单状态 0 启用，1禁用
     */
    private Integer status;

    /**
     * 父类id
     */
    private Integer parentId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(Integer menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getLeadPath() {
        return leadPath;
    }

    public void setLeadPath(String leadPath) {
        this.leadPath = leadPath;
    }

    public String getBackPath() {
        return backPath;
    }

    public void setBackPath(String backPath) {
        this.backPath = backPath;
    }

    public String getRedirectPath() {
        return redirectPath;
    }

    public void setRedirectPath(String redirectPath) {
        this.redirectPath = redirectPath;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ZeusMenu{" +
                "id=" + id +
                ", menuCode='" + menuCode + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuIcon=" + menuIcon +
                ", component='" + component + '\'' +
                ", leadPath='" + leadPath + '\'' +
                ", backPath='" + backPath + '\'' +
                ", redirectPath='" + redirectPath + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}