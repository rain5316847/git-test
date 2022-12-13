package com.example.fastzhejiang.controller;

import com.example.fastremote.remote.LocalRemote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private LocalRemote localRemote;

    @PostMapping("/get")
    public String getMsg(@RequestBody String name){
        log.info("name:{}",name);
        return localRemote.getMsg(name).toString();
    }

    @GetMapping("/hello")
    public String HelloWorld(){
        return "HelloWorld-remote";
    }
}
