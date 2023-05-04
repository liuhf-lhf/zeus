package com.liuhf.user.api.feign;

import com.liuhf.user.api.dto.ZeusUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liuhf
 * @date 2023/4/27
 * @since 1.0
 */
@FeignClient("user-service")
public interface UserFeign {

    @GetMapping("/user/fu")
    ZeusUserDto findByUsername(@RequestParam("username") String username);
}
