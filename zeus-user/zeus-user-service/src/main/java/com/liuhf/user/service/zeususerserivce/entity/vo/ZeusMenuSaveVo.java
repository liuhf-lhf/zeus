package com.liuhf.user.service.zeususerserivce.entity.vo;

import com.liuhf.user.service.zeususerserivce.entity.ZeusMenu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 菜单新增实体
 */
public class ZeusMenuSaveVo {

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
    private String menuIcon;

    /**
     * 前端主键 view 之后路径即可
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
     * 类型，0菜单，1按钮
     */
    private Integer type;

    /**
     * 状态 0启用。1禁用
     */
    private Integer status;

    /**
     * 父类id
     */
    private Integer parentId;


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


    @Override
    public String toString() {
        return "ZeusMenuSaveVo{" +
                "menuCode='" + menuCode + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuIcon=" + menuIcon +
                ", component='" + component + '\'' +
                ", leadPath='" + leadPath + '\'' +
                ", backPath='" + backPath + '\'' +
                ", redirectPath='" + redirectPath + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", parentId=" + parentId +
                '}';
    }

    public ZeusMenu covertZeusMenu() {
        ZeusMenu menu = new ZeusMenu();
        menu.setMenuCode(this.menuCode);
        menu.setMenuName(this.menuName);
        menu.setMenuIcon(this.menuIcon);
        menu.setComponent(this.component);
        menu.setLeadPath(this.leadPath);
        menu.setBackPath(this.backPath);
        menu.setRedirectPath(this.redirectPath);
        menu.setType(this.type);
        menu.setStatus(this.status);
        menu.setParentId(this.parentId);
        return menu;
    }
}