package com.liuhf.user.service.zeususerserivce.repository;

import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ZeusRoleRepository extends JpaRepository<ZeusRole, Integer>, JpaSpecificationExecutor<ZeusRole> {
    @Query("""
            select r from ZeusRole r
            inner join ZeusUserRole ur on r.id=ur.id.roleId
            where ur.id.userId=?1 and r.status=?2
            """)
    List<ZeusRole> findRoleByUsers_Id(Long id, Integer status);
}