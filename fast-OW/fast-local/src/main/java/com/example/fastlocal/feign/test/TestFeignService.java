package com.example.fastlocal.feign.test;

import com.example.fastlocal.entity.shuyun.PPartner;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// @FeignClient(name="fast-test",path = "/test/test")
public interface TestFeignService {

    @GetMapping("/hello")
    String hello();

    @PostMapping("/get")
    PPartner getPartner();

}
