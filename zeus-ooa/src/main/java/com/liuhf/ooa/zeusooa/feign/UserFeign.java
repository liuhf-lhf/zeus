package com.liuhf.ooa.zeusooa.feign;

import com.liuhf.user.api.dto.ZeusUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuhf
 * @date 2023/4/18
 * @since 1.0
 */
@FeignClient("user-service")
public interface UserFeign {

    @GetMapping("login")
    ZeusUserDto findByUsername(String username);

}
