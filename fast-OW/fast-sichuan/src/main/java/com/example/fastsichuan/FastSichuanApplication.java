package com.example.fastsichuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.example.fastremote"})
@EnableDiscoveryClient
public class FastSichuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastSichuanApplication.class, args);
    }

}
