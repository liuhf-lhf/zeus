package com.liuhf.user.service.zeususerserivce.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ZeusRoleMenuId implements Serializable {
    private static final long serialVersionUID = 4940064662634886626L;
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "menu_id", nullable = false)
    private Integer menuId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ZeusRoleMenuId entity = (ZeusRoleMenuId) o;
        return Objects.equals(this.roleId, entity.roleId) &&
                Objects.equals(this.menuId, entity.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, menuId);
    }

}