package com.liuhf.user.service.zeususerserivce.repository;

import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ZeusRoleRepository extends JpaRepository<ZeusRole, Integer>, JpaSpecificationExecutor<ZeusRole> {
}