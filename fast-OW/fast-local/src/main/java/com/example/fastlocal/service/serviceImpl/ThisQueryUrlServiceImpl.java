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
import com.example.fastlocal.utils.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class ThisQueryUrlServiceImpl extends ServiceImpl<ThisQueryUrlMapper, ThisQueryUrl> implements IThisQueryUrlService {

    @Autowired
    private IThisQueryProductInfoService iThisQueryProductInfoService;

    @Autowired
    private RedisUtils redisUtils;

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
        }else if(product.equals("2") && data.get("该产品信息为") != null){

            String dataInner = data.get("该产品信息为").toString();
            JSONObject jsonInner = JSONObject.parseObject(dataInner);
            String extendProperties = jsonInner.getString("extendProperties");
            JSONObject jsonInnerExtendProperties = JSONObject.parseObject(extendProperties);
            String QRCode = (String) data.get("该产品二维码为");
            String parent = jsonInner.getString("parent");
            String productId = jsonInner.getString("productId");
            String produceTime = jsonInner.getString("produceTime");
            String dmCode = jsonInner.getString("dmCode");
            String storeCode = jsonInnerExtendProperties.getString("storeCode");
            String storeName = jsonInnerExtendProperties.getString("storeName");
            String productCode = jsonInner.getString("productCode");
            String productName = jsonInner.getString("productName");

            thisQueryProductInfo = ThisQueryProductInfo.create(
                    urlId,
                    product,
                    QRCode,
                    parent,
                    productId,
                    produceTime,
                    dmCode,
                    storeCode,
                    storeName,
                    productCode,
                    productName
            );
        }else if(product.equals("2") && data.get("该产品信息为") == null){
            thisQueryProductInfo = ThisQueryProductInfo.create(
                    urlId,
                    product,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );
        }

        iThisQueryProductInfoService.insertThisQueryProductInfo(thisQueryProductInfo);
        baseMapper.insert(thisQueryUrl);
        redisUtils.setQRMsgToRedis(thisQueryProductInfo);
        return urlId;
    }

}
