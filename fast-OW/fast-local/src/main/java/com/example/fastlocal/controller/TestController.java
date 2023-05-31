package com.example.fastlocal.controller;

import com.example.fastlocal.feign.test.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestFeignService testFeignService;

    @GetMapping("/hello")
    public String helloFeign(){
        return testFeignService.hello();
    }
}
