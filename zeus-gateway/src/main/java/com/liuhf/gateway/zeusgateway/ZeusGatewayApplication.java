package com.liuhf.gateway.zeusgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZeusGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeusGatewayApplication.class, args);
    }

}
