package com.liuhf.ooa.zeusooa.repository;

import com.liuhf.ooa.zeusooa.entity.ZeusAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ZeusAuthorizationRepository extends JpaRepository<ZeusAuthorization, String>, JpaSpecificationExecutor<ZeusAuthorization> {
}