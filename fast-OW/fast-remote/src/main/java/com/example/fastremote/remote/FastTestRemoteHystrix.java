package com.example.fastremote.remote;

import com.example.fastremote.entity.R;
import org.springframework.stereotype.Component;

@Component
public class FastTestRemoteHystrix implements FastTestRemote{
    @Override
    public String hello() {
        R result = R.of();
        result.error(500,"服务未准备好");
        return result.toString();
    }
}
