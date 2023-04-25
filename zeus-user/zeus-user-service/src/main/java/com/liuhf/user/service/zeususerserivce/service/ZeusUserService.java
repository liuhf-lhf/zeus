package com.liuhf.user.service.zeususerserivce.service;

import com.liuhf.user.api.dto.ZeusUserDto;
import com.liuhf.user.service.zeususerserivce.entity.ZeusUser;
import org.springframework.data.domain.Page;

/**
 * @author liuhf
 * @date 2023/4/12
 * @since 1.0
 */
public interface ZeusUserService {

    boolean save(ZeusUser entity);

    boolean deleteById(Long id);

    boolean modifyById(ZeusUser entity);

    ZeusUser findOneById(Long id);

    Page<ZeusUser> findAny(String username, String realName, Integer page, Integer pageSize);

    ZeusUser findOneByUsername(String username);
}