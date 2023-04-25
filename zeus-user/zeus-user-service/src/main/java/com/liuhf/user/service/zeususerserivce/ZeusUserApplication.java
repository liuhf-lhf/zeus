package com.liuhf.user.service.zeususerserivce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories("com.liuhf.user.service.zeususerserivce.repository")
public class ZeusUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeusUserApplication.class, args);
    }

}
