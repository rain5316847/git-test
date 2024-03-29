package com.example.fasttest.controller;

import com.example.fasttest.entity.PPartner;
import com.example.fasttest.mapper.PPartnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class PPartnerController {

    @Autowired
    private PPartnerMapper pPartnerMapper;

    @PostMapping("/get")
    public PPartner getPartner (@RequestBody String id){
       // redisTemplate.opsForHash().
        return pPartnerMapper.getPartner(id);
    }

    @GetMapping("/hello")
    public String hello(){
        return "HelloTest";
    }
}
