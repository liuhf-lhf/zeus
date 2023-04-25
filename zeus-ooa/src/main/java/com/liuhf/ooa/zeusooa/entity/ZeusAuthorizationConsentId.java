package com.liuhf.ooa.zeusooa.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ZeusAuthorizationConsentId implements Serializable {
    private static final long serialVersionUID = -1945351134045605518L;
    @Column(name = "principal_name", nullable = false)
    private String principalName;

    @Column(name = "registered_client_id", nullable = false)
    private String registeredClientId;

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getRegisteredClientId() {
        return registeredClientId;
    }

    public void setRegisteredClientId(String registeredClientId) {
        this.registeredClientId = registeredClientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ZeusAuthorizationConsentId entity = (ZeusAuthorizationConsentId) o;
        return Objects.equals(this.registeredClientId, entity.registeredClientId) &&
                Objects.equals(this.principalName, entity.principalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registeredClientId, principalName);
    }

}