package com.example.fastsichuan.controller;

import com.example.fastsichuan.service.ITSignDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/tSignDetail")
public class TSignDetailController {

    @Autowired
    private ITSignDetailService itSignDetailService;

    @PostMapping("/updateEpcS")
    public void updateEpcS(@RequestBody String epc){
        itSignDetailService.updateEpcS(epc);
    }

}
