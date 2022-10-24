package com.example.workdaka.controller.sichuan;

import com.example.workdaka.service.sichuan.ITPackingListService;
import com.example.workdaka.utils.R;
import com.example.workdaka.utils.common.EmptyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
