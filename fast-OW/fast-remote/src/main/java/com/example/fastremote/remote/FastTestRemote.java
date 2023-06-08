package com.example.fastremote.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="fast-test",fallback = FastTestRemoteHystrix.class)
public interface FastTestRemote {

    @RequestMapping(value = "/test/test/hello",method = RequestMethod.GET)
    String hello();

}
