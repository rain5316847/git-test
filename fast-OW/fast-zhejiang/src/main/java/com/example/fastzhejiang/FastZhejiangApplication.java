package com.example.fastzhejiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.example.fastremote.remote"})
public class FastZhejiangApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastZhejiangApplication.class, args);
    }

}
