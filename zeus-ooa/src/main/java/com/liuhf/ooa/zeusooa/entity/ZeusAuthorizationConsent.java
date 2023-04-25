package com.liuhf.ooa.zeusooa.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "zeus_authorization_consent")
public class ZeusAuthorizationConsent {
    @EmbeddedId
    private ZeusAuthorizationConsentId id;

    @Column(name = "authorities", nullable = false, length = 1000)
    private String authorities;

    public ZeusAuthorizationConsentId getId() {
        return id;
    }

    public void setId(ZeusAuthorizationConsentId id) {
        this.id = id;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

}