package com.example.fastsichuan.controller;

import com.example.fastsichuan.service.ITPackingListService;
import com.example.fastsichuan.utils.R;
import com.example.fastsichuan.utils.common.EmptyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/tPackingList")
public class TPackingListController {

    @Autowired
    private ITPackingListService itPackingListService;

    @PostMapping("/getCapMsg")
    public R getCapMsg(@RequestBody String urlId){
        EmptyUtils.strEmpty(urlId,"产品不能为空！");
        return itPackingListService.getCapMsg(urlId);
    }

}
