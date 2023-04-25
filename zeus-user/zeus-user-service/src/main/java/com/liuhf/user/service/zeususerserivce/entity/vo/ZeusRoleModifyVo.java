package com.liuhf.user.service.zeususerserivce.entity.vo;

import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;

/**
 * 角色修改实体
 */
public class ZeusRoleModifyVo {
    /**
     * 角色主键
     */
    private Integer id;
    /**
     * 角色代码
     */
    private String roleCode;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 状态
     */
    private Integer status;

    public ZeusRole convertZeusRole() {
        ZeusRole role = new ZeusRole();
        role.setId(id);
        role.setRoleName(this.roleName);
        role.setRoleCode(this.roleCode);
        role.setStatus(this.status);
        return role;
    }

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


}