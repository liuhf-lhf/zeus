package com.liuhf.ooa.zeusooa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "zeus_authorization_consent")
@IdClass(ZeusAuthorizationConsent.ZeusAuthorizationConsentId.class)
public class ZeusAuthorizationConsent implements Serializable {
    @Id
    private String registeredClientId;
    @Id
    private String principalName;
    @Column(name = "authorities")
    private String authorities;

    public static class ZeusAuthorizationConsentId implements Serializable {
        private String registeredClientId;
        private String principalName;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ZeusAuthorizationConsentId that = (ZeusAuthorizationConsentId) o;
            return registeredClientId.equals(that.registeredClientId) && principalName.equals(that.principalName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(registeredClientId, principalName);
        }
    }

    public String getRegisteredClientId() {
        return registeredClientId;
    }

    public void setRegisteredClientId(String registeredClientId) {
        this.registeredClientId = registeredClientId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}