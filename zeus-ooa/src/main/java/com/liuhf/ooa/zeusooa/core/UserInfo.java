package com.liuhf.ooa.zeusooa.core;

import com.liuhf.user.api.dto.ZeusRoleDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liuhf
 * @date 2023/4/18
 * @since 1.0
 */
public class UserInfo implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private String headImg;
    private String realName;
    private String phone;
    private String email;
    private Integer lock;
    private Set<ZeusRoleDto> zeusRoles;

    public UserInfo() {
    }

    public UserInfo(Long id, String username, String password, String headImg, String realName, String phone, String email, Integer lock, Set<ZeusRoleDto> zeusRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.headImg = headImg;
        this.realName = realName;
        this.phone = phone;
        this.email = email;
        this.lock = lock;
        this.zeusRoles = zeusRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return zeusRoles.stream().map(r -> new SimpleGrantedAuthority(r.roleCode())).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.lock == 0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLock() {
        return lock;
    }

    public void setLock(Integer lock) {
        this.lock = lock;
    }

    public Set<ZeusRoleDto> getZeusRoles() {
        return zeusRoles;
    }

    public void setZeusRoles(Set<ZeusRoleDto> zeusRoles) {
        this.zeusRoles = zeusRoles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", headImg='" + headImg + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", lock=" + lock +
                ", zeusRoles=" + zeusRoles +
                '}';
    }
}
