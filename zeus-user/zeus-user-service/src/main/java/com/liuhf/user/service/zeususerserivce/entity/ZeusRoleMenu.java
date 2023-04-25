package com.liuhf.user.service.zeususerserivce.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "zeus_role_menu")
public class ZeusRoleMenu {
    @EmbeddedId
    private ZeusRoleMenuId id;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "role_id", nullable = false)
    private ZeusRole role;

    @MapsId("menuId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "menu_id", nullable = false)
    private ZeusMenu menu;

    public ZeusRoleMenuId getId() {
        return id;
    }

    public void setId(ZeusRoleMenuId id) {
        this.id = id;
    }

    public ZeusRole getRole() {
        return role;
    }

    public void setRole(ZeusRole role) {
        this.role = role;
    }

    public ZeusMenu getMenu() {
        return menu;
    }

    public void setMenu(ZeusMenu menu) {
        this.menu = menu;
    }

}