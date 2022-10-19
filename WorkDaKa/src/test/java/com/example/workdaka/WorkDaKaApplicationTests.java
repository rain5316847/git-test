package com.example.workdaka;

import com.example.workdaka.service.local.IQRCodeService;
import com.example.workdaka.service.local.ITestService;
import com.example.workdaka.service.local.IUserService;
import com.example.workdaka.service.sichuan.ITPackingInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkDaKaApplicationTests {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IQRCodeService iqrCodeService;

    @Autowired
    private ITestService iTestService;

    @Autowired
    private ITPackingInfoService itPackingInfoService;

    @Test
    void test1(){
        System.out.println(itPackingInfoService.getPackingInfo("A0CXW6YS283"));
    }

}

