package com.liuhf.user.service.zeususerserivce.repository;

import com.liuhf.user.service.zeususerserivce.entity.ZeusUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ZeusUserRepository extends JpaRepository<ZeusUser, Long>, JpaSpecificationExecutor<ZeusUser> {
    Optional<ZeusUser> findZeusUserByUsername(@NonNull String username);
}