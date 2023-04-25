package com.liuhf.user.service.zeususerserivce.repository;

import com.liuhf.user.service.zeususerserivce.entity.ZeusMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ZeusMenuRepository extends JpaRepository<ZeusMenu, Integer>, JpaSpecificationExecutor<ZeusMenu> {
}