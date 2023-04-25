package com.liuhf.ooa.zeusooa.repository;

import com.liuhf.ooa.zeusooa.entity.ZeusAuthorizationConsent;
import com.liuhf.ooa.zeusooa.entity.ZeusAuthorizationConsentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ZeusAuthorizationConsentRepository extends JpaRepository<ZeusAuthorizationConsent, ZeusAuthorizationConsentId>, JpaSpecificationExecutor<ZeusAuthorizationConsent> {
}