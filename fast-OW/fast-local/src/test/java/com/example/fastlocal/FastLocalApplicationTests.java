package com.example.fastlocal;


import com.example.fastlocal.utils.redis.RedisUtils;
import com.example.fastremote.remote.FastTestRemote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FastLocalApplicationTests {

    @Autowired
    private FastTestRemote fastTestRemote;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void dmCodeTest() {

        System.out.println(redisUtils.getInfoFromRedis("thisQueryProductInfo:1443d874af190cd06a1f786479c208c3"));

    }



}
