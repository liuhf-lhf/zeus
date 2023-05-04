package com.liuhf.ooa.zeusooa.core;

import com.liuhf.user.api.dto.ZeusUserDto;
import com.liuhf.user.api.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author liuhf
 * @date 2023/4/18
 * @since 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserFeign userFeign;

    @Autowired
    public void setUserFeign(UserFeign userFeign) {
        this.userFeign = userFeign;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ZeusUserDto user = Optional.ofNullable(userFeign.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("用户不存在!!!"));

        //        return new UserInfo(user.id(), user.username(), user.password(), user.headImg(), user.realName(), user.phone(), user.email(), user.lock(), user.zeusRoles());
        return User.withUsername(user.username())
                .password(user.password())
                .accountExpired(false)
                .accountLocked(user.lock() == 1)
                .credentialsExpired(false)
                .disabled(false)
                .authorities(user.zeusRoles().stream().map(r -> new SimpleGrantedAuthority(r.roleCode())).collect(Collectors.toList()))
                .build();
    }
}
