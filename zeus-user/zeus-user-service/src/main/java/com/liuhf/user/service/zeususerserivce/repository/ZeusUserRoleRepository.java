package com.liuhf.user.service.zeususerserivce.repository;

import com.liuhf.user.service.zeususerserivce.entity.ZeusUserRoleId;
import com.liuhf.user.service.zeususerserivce.entity.ZeusUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ZeusUserRoleRepository extends JpaRepository<ZeusUserRole, ZeusUserRoleId>, JpaSpecificationExecutor<ZeusUserRole> {
}