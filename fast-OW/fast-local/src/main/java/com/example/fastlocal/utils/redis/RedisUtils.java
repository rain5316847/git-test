package com.example.fastlocal.utils.redis;

import com.example.fastlocal.entity.ThisQueryProductInfo;
import com.example.fastlocal.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setQRMsgToRedis(ThisQueryProductInfo thisQueryProductInfo){
        stringRedisTemplate.opsForValue().set("thisQueryProductInfo"+":"+thisQueryProductInfo.getId(), JSONUtils.Object2String(thisQueryProductInfo),10, TimeUnit.MINUTES);
    }

    public ThisQueryProductInfo getInfoFromRedis(String id){
        ThisQueryProductInfo thisQueryProductInfo = (ThisQueryProductInfo) JSONUtils.String2Object(stringRedisTemplate.opsForValue().get(id),ThisQueryProductInfo.class);
        return thisQueryProductInfo;
    }


}
