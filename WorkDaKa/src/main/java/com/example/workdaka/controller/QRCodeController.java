package com.example.workdaka.controller;

import com.example.workdaka.service.IQRCodeService;
import com.example.workdaka.utils.R;
import com.google.zxing.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

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

    @PostMapping("/IdentifyQRCode")
    public R IdentifyQRCode(@RequestBody String url) throws NotFoundException, IOException {
        log.info("url:{}",url);
        return iqrCodeService.IdentifyQRCode(url);
    }

    @PostMapping("/GenerateQRCode")
    public BufferedImage GenerateQRCode(@RequestBody String msg){
        log.info("msg:{}",msg);
        return iqrCodeService.GenerateQRCode(msg);
    }

}
