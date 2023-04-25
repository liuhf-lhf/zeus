package com.liuhf.ooa.zeusooa.core;

import com.liuhf.ooa.zeusooa.feign.UserFeign;
import com.liuhf.user.api.dto.ZeusUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return new UserInfo(user.id(), user.username(), user.password(), user.headImg(), user.realName(), user.phone(), user.email(), user.lock(), user.zeusRoles());
    }
}
