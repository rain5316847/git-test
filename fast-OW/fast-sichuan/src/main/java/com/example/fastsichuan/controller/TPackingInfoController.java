package com.example.fastsichuan.controller;

import com.example.fastsichuan.service.ITPackingInfoService;
import com.example.fastsichuan.utils.R;
import com.example.fastsichuan.utils.common.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tPackingInfo")
public class TPackingInfoController {

    @Autowired
    private ITPackingInfoService itPackingInfoService;

    @PostMapping("/getPackingMsg")
    public R getCapMsg(@RequestBody String urlId){
        EmptyUtils.strEmpty(urlId,"产品不能为空！");
        return itPackingInfoService.getPackingInfoMsg(urlId);
    }

}
