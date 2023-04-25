package com.liuhf.ooa.zeusooa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebSecurity
@EnableFeignClients("com.liuhf.ooa.zeusooa.feign")
public class ZeusOoaApplication {
    private static final Logger logger = LoggerFactory.getLogger(ZeusOoaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZeusOoaApplication.class, args);
        logger.info("Zeus ooa server is started");
    }

}
