package com.example.workdaka;

import com.example.workdaka.mapper.local.UserMapper;
import com.example.workdaka.mapper.sichuan.TCapScanMapper;
import com.example.workdaka.mapper.sichuan.TPackingListMapper;
import com.example.workdaka.mapper.sichuan.TProductMapper;
import com.example.workdaka.mapper.sichuan.TSignMapper;
import com.example.workdaka.service.local.IQRCodeService;
import com.example.workdaka.service.local.ITestService;
import com.example.workdaka.service.local.IUserService;
import com.example.workdaka.service.sichuan.ITPackingInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private TPackingListMapper tPackingListMapper;

    @Autowired
    private TProductMapper tProductMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TCapScanMapper tCapScanMapper;

    @Autowired
    private TSignMapper tSignMapper;

    @Test
    void test1(){
        System.out.println(itPackingInfoService.getPackingInfo("A0CXW6YS283"));
    }

    @Test
    void test2(){
        System.out.println(tPackingListMapper.queryCapMsg("2GML557HSY",""));
    }

    @Test
    void test3(){
        System.out.println(iUserService.all());
    }

    @Test
    void test4(){
        System.out.println(tProductMapper.getOneTProduct("184507140"));
    }

    @Test
    void test6(){
        System.out.println(userMapper.getMsg("3"));
    }

    @Test
    void test7() throws UnsupportedEncodingException {
        System.out.println(iqrCodeService.queryMsgWithQRCode("https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M1"));
    }

    @Test
    void test8() {tCapScanMapper.queryCapScan("2GML557HSY");}

    @Test
    void test9(){
        System.out.println(tSignMapper.getPackingSign("F2VMATYX*FA3P2-.O*+6D"));}

    @Test
    void test10(){
        List<String> list1 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("3");
        List<List<String>> list2 = new ArrayList<>();
        list2.add(list1);
        System.out.println(list2);
    }
}

