package com.example.fastsichuan.service.impl;

import com.example.fastremote.entity.R;
import com.example.fastremote.remote.FastLocalRemote;
import com.example.fastsichuan.entity.ThisQueryProductInfo;
import com.example.fastsichuan.service.IThisQueryProductInfoService;
import com.example.fastsichuan.utils.common.JSONUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class IThisQueryProductInfoServiceImpl implements IThisQueryProductInfoService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private FastLocalRemote fastLocalRemote;

    @Override
    public ThisQueryProductInfo getInfo(String id) {
        ThisQueryProductInfo thisQueryProductInfo = this.getInfoFromRedis("ThisQueryProductInfo"+id);
        if (thisQueryProductInfo == null){
            thisQueryProductInfo = this.getInfoFromFastLocal(id);
        }
        return thisQueryProductInfo;
    }

    @Override
    public ThisQueryProductInfo getInfoFromRedis(String id){
        try {
            return (ThisQueryProductInfo) JSONUtils.String2Object(stringRedisTemplate.opsForValue().get(id),ThisQueryProductInfo.class);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void setInfoToRedis(ThisQueryProductInfo thisQueryProductInfo){
        stringRedisTemplate.opsForValue().set("thisQueryProductInfo"+":"+thisQueryProductInfo.getId(), JSONUtils.Object2String(thisQueryProductInfo),10, TimeUnit.MINUTES);
    }

    @Override
    public ThisQueryProductInfo getInfoFromFastLocal(String id) {
        R r = fastLocalRemote.getQRMsgWithId(id);
        if(!(9999 == r.getCode())){
            Map<String,Object> map = r.getData();
            ThisQueryProductInfo thisQueryProductInfo = new ObjectMapper().convertValue(map.get("ThisQueryProductInfo"),ThisQueryProductInfo.class);
            log.info("============thisQueryProductInfo:{}================",thisQueryProductInfo);
            this.setInfoToRedis(thisQueryProductInfo);
            return thisQueryProductInfo;
        }else {
            return null;
        }
    }


}
