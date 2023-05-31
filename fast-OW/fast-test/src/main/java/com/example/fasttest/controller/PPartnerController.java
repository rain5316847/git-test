package com.example.fasttest.controller;

import com.example.fasttest.entity.PPartner;
import com.example.fasttest.mapper.PPartnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/test")
@EnableFeignClients
public class PPartnerController {

    @Autowired
    private PPartnerMapper pPartnerMapper;

    @PostMapping("/get")
    public PPartner getPartner (@RequestBody String id){
        return pPartnerMapper.getPartner(id);
    }

    @GetMapping("/hello")
    public String hello(){
        return "HelloTest";
    }
}
