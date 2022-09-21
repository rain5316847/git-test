package com.example.workdaka.controller;

import com.example.workdaka.service.IQRCodeService;
import com.example.workdaka.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/QRCode")
public class QRCodeController {

    @Autowired
    private IQRCodeService iqrCodeService;

    /*@GetMapping("/QueryMsgWithQRCode")
    public R QueryMsgWithQRCode(@RequestParam String url){
        log.info("url:{}",url);
        return  iqrCodeService.QueryMsgWithQRCode(url);
    }*/
    //设备2git提交测试

    @PostMapping("/QueryMsgWithQRCode")
    public R QueryMsgWithQRCode(@RequestBody String url){
        log.info("url:{}",url);
        return  iqrCodeService.QueryMsgWithQRCode(url);
    }

}
