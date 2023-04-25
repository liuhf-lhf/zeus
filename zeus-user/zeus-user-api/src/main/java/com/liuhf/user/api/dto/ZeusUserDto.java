package com.liuhf.user.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link com.liuhf.user.service.zeususerserivce.entity.ZeusUser} entity
 */
public record ZeusUserDto(Long id, String username, String password, String headImg, String realName, String phone,
                          String email, Integer lock, Date createTime, Date updateTime,
                          Set<ZeusRoleDto> zeusRoles) implements Serializable {
}