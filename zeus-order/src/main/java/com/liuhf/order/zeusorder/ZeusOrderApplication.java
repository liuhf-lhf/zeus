package com.liuhf.order.zeusorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZeusOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeusOrderApplication.class, args);
    }

}
