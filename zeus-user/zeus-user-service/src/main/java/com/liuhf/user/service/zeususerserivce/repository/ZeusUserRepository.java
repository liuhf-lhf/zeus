package com.liuhf.user.service.zeususerserivce.repository;

import com.liuhf.user.api.dto.ZeusUserDto;
import com.liuhf.user.service.zeususerserivce.entity.ZeusUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ZeusUserRepository extends JpaRepository<ZeusUser, Long>, JpaSpecificationExecutor<ZeusUser> {
    @Query("select z from ZeusUser z inner join ZeusUserRole zr on z.id=zr.user.id inner join ZeusRole r on r.id=zr.role.id where z.username = ?1")
    Optional<ZeusUser> findByUsernameAndLock(@NonNull String username);
}