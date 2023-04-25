package com.liuhf.user.api.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.liuhf.user.service.zeususerserivce.entity.ZeusRole} entity
 */
public record ZeusRoleDto(Integer id, String roleCode, String roleName, Integer status, Date createTime,
                          Date updateTime) implements Serializable {
}