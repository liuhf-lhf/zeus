package com.liuhf.ooa.zeusooa.repository;

import com.liuhf.ooa.zeusooa.entity.ZeusAuthorizationConsent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZeusAuthorizationConsentRepository extends JpaRepository<ZeusAuthorizationConsent, ZeusAuthorizationConsent.ZeusAuthorizationConsentId> {
    Optional<ZeusAuthorizationConsent> findByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);

    void deleteByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
}


