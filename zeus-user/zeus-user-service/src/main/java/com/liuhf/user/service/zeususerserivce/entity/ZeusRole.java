package com.liuhf.user.service.zeususerserivce.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zeus_role")
@DynamicInsert
@DynamicUpdate
public class ZeusRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role_code", nullable = false, length = 10)
    private String roleCode;

    @Column(name = "role_name", length = 20)
    private String roleName;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "create_time", nullable = false,insertable = false,updatable = false)
    private Date createTime;

    @Column(name = "update_time",insertable = false,updatable = false)
    private Date updateTime;

    @ManyToMany
    @JoinTable(name = "zeus_role_menu",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<ZeusMenu> zeusMenus = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Set<ZeusMenu> getZeusMenus() {
        return zeusMenus;
    }

    public void setZeusMenus(Set<ZeusMenu> zeusMenus) {
        this.zeusMenus = zeusMenus;
    }

    @Override
    public String toString() {
        return "ZeusRole{" +
                "id=" + id +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", zeusMenus=" + zeusMenus +
                '}';
    }
}