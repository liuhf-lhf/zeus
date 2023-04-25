package com.liuhf.user.service.zeususerserivce.entity.vo;

import com.liuhf.user.service.zeususerserivce.entity.ZeusMenu;
import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 角色新增实体
 */
public class ZeusRoleSaveVo {
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
        role.setRoleName(this.roleName);
        role.setRoleCode(this.roleCode);
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


}