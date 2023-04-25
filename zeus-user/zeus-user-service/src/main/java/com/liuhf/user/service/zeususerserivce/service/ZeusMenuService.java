package com.liuhf.user.service.zeususerserivce.service;

import com.liuhf.user.service.zeususerserivce.entity.ZeusMenu;
import org.springframework.data.domain.Page;

/**
 * @author liuhf
 * @date 2023/4/24
 * @since 1.0
 */
public interface ZeusMenuService {

    boolean save(ZeusMenu entity);

    boolean deleteById(Integer id);

    boolean modifyById(ZeusMenu entity);

    ZeusMenu findById(Integer id);

    Page<ZeusMenu> findAny(ZeusMenu menu, int page, int pageSize);
}