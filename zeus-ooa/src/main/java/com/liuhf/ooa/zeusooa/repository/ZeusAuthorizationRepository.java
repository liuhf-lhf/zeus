package com.liuhf.ooa.zeusooa.repository;

import com.liuhf.ooa.zeusooa.entity.ZeusAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ZeusAuthorizationRepository extends JpaRepository<ZeusAuthorization, String>, JpaSpecificationExecutor<ZeusAuthorization> {
    Optional<ZeusAuthorization> findByState(String state);

    Optional<ZeusAuthorization> findByAuthorizationCodeValue(String authorizationCode);

    Optional<ZeusAuthorization> findByAccessTokenValue(String accessToken);

    Optional<ZeusAuthorization> findByRefreshTokenValue(String refreshToken);

    @Query("select a from ZeusAuthorization a where a.state = :token" +
            " or a.authorizationCodeValue = :token" +
            " or a.accessTokenValue = :token" +
            " or a.refreshTokenValue = :token"
    )
    Optional<ZeusAuthorization> findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValue(@Param("token") String token);
}