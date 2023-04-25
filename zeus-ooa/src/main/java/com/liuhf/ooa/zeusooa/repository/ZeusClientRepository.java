package com.liuhf.ooa.zeusooa.repository;

import com.liuhf.ooa.zeusooa.entity.ZeusClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ZeusClientRepository extends JpaRepository<ZeusClient, String>, JpaSpecificationExecutor<ZeusClient> {
    Optional<ZeusClient> findByClientId(String clientId);


}