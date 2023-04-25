package com.liuhf.user.service.zeususerserivce.entity.vo;

import com.liuhf.common.lang.ZRequestPage;
import com.liuhf.user.service.zeususerserivce.entity.ZeusMenu;

/**
 * 菜单搜索实体
 */
public class ZeusMenuSearchVo extends ZRequestPage {

    /**
     * 菜单代码
     */
    private String menuCode;
    /**
     * 菜单名
     */
    private String menuName;
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



    public ZeusMenu covertZeusMenu() {
        ZeusMenu menu = new ZeusMenu();
        menu.setMenuCode(this.menuCode);
        menu.setMenuName(this.menuName);
        menu.setType(this.type);
        menu.setStatus(this.status);
        menu.setParentId(this.parentId);
        return menu;
    }
}