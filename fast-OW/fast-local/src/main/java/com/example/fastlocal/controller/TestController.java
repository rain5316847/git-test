package com.example.fastlocal.controller;

import com.example.fastlocal.feign.test.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//该类为local的提供类，负责提供数据给其他服务
public class TestController {

}
