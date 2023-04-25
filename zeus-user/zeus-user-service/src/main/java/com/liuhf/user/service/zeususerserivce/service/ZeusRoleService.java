package com.liuhf.user.service.zeususerserivce.service;

import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;
import org.springframework.data.domain.Page;

/**
 * @author liuhf
 * @date 2023/4/24
 * @since 1.0
 */
public interface ZeusRoleService {

    boolean save(ZeusRole entity);

    boolean deleteById(Integer entity);

    boolean modifyById(ZeusRole entity);

    ZeusRole findOneById(Integer id);

    Page<ZeusRole> findAny(ZeusRole zeusRole, int page, int pageSize);
}