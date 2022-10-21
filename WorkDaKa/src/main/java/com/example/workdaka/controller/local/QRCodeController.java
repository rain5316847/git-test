package com.example.workdaka.controller.local;

import com.example.workdaka.entity.local.QueryQRCode;
import com.example.workdaka.service.local.IQRCodeService;
import com.example.workdaka.utils.Common.EmptyUtils;
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

    /**
    * 查询产品信息
    */
    @PostMapping("/queryMsgWithQRCode")
    public R queryMsgWithQRCode(@RequestBody QueryQRCode queryQRCode) {

        EmptyUtils.strEmpty(queryQRCode.getType(),"查询类型不能为空！");
        EmptyUtils.strEmpty(queryQRCode.getCode(),"查询编码不能为空！");
        EmptyUtils.strEmpty(queryQRCode.getProduct(),"产品类别不能为空！");

        log.info("queryQRCode:{}",queryQRCode);
        return  iqrCodeService.queryMsgWithQRCode(queryQRCode);
    }

}
