package com.example.workdaka.service.serviceImpl;


import com.alibaba.fastjson.JSONObject;
import com.example.workdaka.service.IQRCodeService;
import com.example.workdaka.utils.HttpClient;
import com.example.workdaka.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class QRCodeServiceImpl implements IQRCodeService {

    @Override
    public R QueryMsgWithQRCode(String url) {

        R r = R.of();
        Map<String,Object> result = new HashMap<>();

        //网址第一次解码之后的信息
        String decode = null;
        //截取”code=“之后的内容
        String interceptURL = null;
        //将”%25“替换为”%“
        String replacement = null;
        //二次解码之后的信息
        String secDecode = null;
        //产品编号，可做生成二维码用
        String goodsNo = null;
        //访问蜀云查询该产品信息的网址
        String interfaceMsg = null;

        if(url == null || url == ""){
            return r.error("请输入二维码识别之后的网址信息。");
        }
        try {
            decode = java.net.URLDecoder.decode(url, "UTF-8");
            log.info("decode:{}",decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        interceptURL = StringUtils.substringBefore((StringUtils.substringAfterLast(decode, "code=")),"\"}");
        log.info("interceptURL:{}",interceptURL);
        replacement = interceptURL.replaceAll("%25","%");
        log.info("replacement:{}",replacement);
        try {
            secDecode = java.net.URLDecoder.decode(replacement, "UTF-8");
            log.info("secDecode:{}",secDecode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        goodsNo = StringUtils.substringAfterLast(secDecode,"/B/");
        log.info("GoodsNo:{}",goodsNo);
        interfaceMsg = HttpClient.queryMsgWithQRCode(secDecode);
        log.info("interfaceMsg:{}",interfaceMsg);
        JSONObject jsonMsg = JSONObject.parseObject(interfaceMsg);

        result.put("该二维码解析的内容为",secDecode);
        result.put("该产品二维码为",goodsNo);
        result.put("该产品信息为",jsonMsg);
        r.put("result",result);

        return r;
    }

}
