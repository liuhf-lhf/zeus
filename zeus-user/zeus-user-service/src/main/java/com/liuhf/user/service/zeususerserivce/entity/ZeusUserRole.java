package com.liuhf.user.service.zeususerserivce.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "zeus_user_role")
public class ZeusUserRole {
    @EmbeddedId
    private ZeusUserRoleId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private ZeusUser user;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "role_id", nullable = false)
    private ZeusRole role;

    public ZeusUserRoleId getId() {
        return id;
    }

    public void setId(ZeusUserRoleId id) {
        this.id = id;
    }

    public ZeusUser getUser() {
        return user;
    }

    public void setUser(ZeusUser user) {
        this.user = user;
    }

    public ZeusRole getRole() {
        return role;
    }

    public void setRole(ZeusRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ZeusUserRole{" +
                "id=" + id +
                ", user=" + user +
                ", role=" + role +
                '}';
    }
}