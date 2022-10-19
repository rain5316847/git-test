package com.example.workdaka.controller;

import com.example.workdaka.service.local.IQRCodeService;
import com.example.workdaka.utils.Common.EmptyUtils;
import com.example.workdaka.utils.R;
import com.google.zxing.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
@RequestMapping("/QRCode")
public class QRCodeController {

    @Autowired
    private IQRCodeService iqrCodeService;

    /*
    * 根据网址查询产品信息
    */
    @PostMapping("/queryMsgWithQRCode")
    public R queryMsgWithQRCode(@RequestBody String url) throws UnsupportedEncodingException {
        EmptyUtils.strEmpty(url,"传入网址信息不能为空！");
        log.info("url:{}",url);
        return  iqrCodeService.queryMsgWithQRCode(url);
    }

    /*
    * 根据二维码查询信息
    */
    @PostMapping("/identifyQRCode")
    public R identifyQRCode(@RequestBody String url) throws NotFoundException, IOException {
        log.info("url:{}",url);
        return iqrCodeService.identifyQRCode(url);
    }

    /*
     * 根据解析结果查询信息
     */
    @PostMapping("/queryMsgWithoutQRCode")
    public R queryMsgWithoutQRCode(@RequestBody String url){
        log.info("url:{}",url);
        return iqrCodeService.queryMsgWithoutQRCode(url);
    }

    /*
     * 生成二维码
     */
    @PostMapping("/generateQRCode")
    public BufferedImage generateQRCode(@RequestBody String msg){
        log.info("msg:{}",msg);
        return iqrCodeService.generateQRCode(msg);
    }

}
