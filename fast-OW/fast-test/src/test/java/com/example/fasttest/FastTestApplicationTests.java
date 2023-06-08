package com.example.fasttest;

import com.example.fasttest.entity.PPartner;
import com.example.fasttest.mapper.PPartnerMapper;
import com.example.fasttest.utils.JSONUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class FastTestApplicationTests {

    @Autowired
    private PPartnerMapper pPartnerMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test1(){

        String pPartner = JSONUtils.Object2String(pPartnerMapper.getPartner("143"));
        //写入redis
        stringRedisTemplate.opsForValue().setIfAbsent("144",pPartner,1, TimeUnit.DAYS);
        PPartner pPartner1 = (PPartner) JSONUtils.String2Object(stringRedisTemplate.opsForValue().get("143"),PPartner.class);
        System.out.println(pPartner1.toString());
    }

}
