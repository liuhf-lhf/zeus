package com.liuhf.user.service.zeususerserivce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "zeus_menu")
public class ZeusMenu {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "menu_code", nullable = false, length = 20)
    private String menuCode;

    @Column(name = "menu_name", nullable = false, length = 20)
    private String menuName;

    @Column(name = "menu_icon")
    private String menuIcon;

    @Column(name = "component", length = 200)
    private String component;

    @Column(name = "lead_path", length = 50)
    private String leadPath;

    @Column(name = "back_path", length = 50)
    private String backPath;

    @Column(name = "redirect_path", nullable = false, length = 50)
    private String redirectPath;

    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "parent_id", nullable = false)
    private Integer parentId;


    @Column(name = "create_time", nullable = false, insertable = false, updatable = false)
    private Date createTime;

    @Column(name = "update_time", insertable = false, updatable = false)
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

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
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