package com.liuhf.user.service.zeususerserivce.repository;

import com.liuhf.user.service.zeususerserivce.entity.ZeusRoleMenu;
import com.liuhf.user.service.zeususerserivce.entity.ZeusRoleMenuId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ZeusRoleMenuRepository extends JpaRepository<ZeusRoleMenu, ZeusRoleMenuId>, JpaSpecificationExecutor<ZeusRoleMenu> {
}