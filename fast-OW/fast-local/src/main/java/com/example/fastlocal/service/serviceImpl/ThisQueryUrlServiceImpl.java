package com.example.fastlocal.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fastlocal.entity.QueryQRCode;
import com.example.fastlocal.entity.ThisQueryProductInfo;
import com.example.fastlocal.entity.ThisQueryUrl;
import com.example.fastlocal.mapper.ThisQueryUrlMapper;
import com.example.fastlocal.service.IThisQueryProductInfoService;
import com.example.fastlocal.service.IThisQueryUrlService;
import com.example.fastlocal.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class ThisQueryUrlServiceImpl extends ServiceImpl<ThisQueryUrlMapper, ThisQueryUrl> implements IThisQueryUrlService {

    @Autowired
    private IThisQueryProductInfoService iThisQueryProductInfoService;

    @Override
    public String insertUrlAndInfo(Map<String,Object> data, QueryQRCode queryQRCode) {
        String urlId = UUIDUtil.createUUId();
        String product = queryQRCode.getProduct();
        ThisQueryProductInfo thisQueryProductInfo = new ThisQueryProductInfo();
        ThisQueryUrl thisQueryUrl = ThisQueryUrl.create(
                urlId,
                queryQRCode.getCode(),
                queryQRCode.getType(),
                product,
                data.toString()
        );
        /*
        * 箱码的查询只有一种情况，只进行unicode解码。
        * 瓶码的查询有两种情况，1：查询出来瓶码数据；2：未查询出来瓶码的数据（null）。
        * */
        if(product.equals("1")){
            thisQueryProductInfo = ThisQueryProductInfo.create(
                    urlId,
                    product,
                    (String) data.get("该产品二维码为")
            );
        }else if(product.equals("2") && data.get("data") != null){

            String dataInner = data.get("data").toString();
            JSONObject jsonInner = JSONObject.parseObject(dataInner);
            String QRCode = (String) data.get("该产品二维码为");
            String dmCode = jsonInner.getString("dmCode");
            String productCode = jsonInner.getString("productCode");
            String productName = jsonInner.getString("productName");

            thisQueryProductInfo = ThisQueryProductInfo.create(
                    urlId,
                    product,
                    QRCode,
                    dmCode,
                    productCode,
                    productName
            );
        }else if(product.equals("2") && data.get("data") == null){
            thisQueryProductInfo = ThisQueryProductInfo.create(
                    urlId,
                    product,
                    null,
                    null,
                    null,
                    null
            );
        };

        iThisQueryProductInfoService.insertThisQueryProductInfo(thisQueryProductInfo);
        baseMapper.insert(thisQueryUrl);
        return urlId;
    }

}
