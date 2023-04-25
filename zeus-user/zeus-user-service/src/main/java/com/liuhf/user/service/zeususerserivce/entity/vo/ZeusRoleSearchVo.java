package com.liuhf.user.service.zeususerserivce.entity.vo;

import com.liuhf.common.lang.ZRequestPage;
import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;

/**
 * 角色查询实体
 */
public class ZeusRoleSearchVo extends ZRequestPage {

    /**
     * 角色代码
     */
    private String roleCode;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色状态 0启用，1禁用
     */
    private Integer status;

    public ZeusRole convertZeusRole() {
        ZeusRole role = new ZeusRole();
        role.setRoleCode(this.roleCode);
        role.setRoleName(this.roleName);
        role.setStatus(this.status);
        return role;
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

    @Override
    public String toString() {
        return "ZeusSearchVo{" +
                "roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", status=" + status +
                '}';
    }
}