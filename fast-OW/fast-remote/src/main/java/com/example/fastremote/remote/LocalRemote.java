package com.example.fastremote.remote;

import com.example.fastremote.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "fast-local")
public interface LocalRemote {

    @RequestMapping(value = "/Login/all",method = RequestMethod.POST)
    R getMsg(@RequestBody String name);

    @RequestMapping(value = "/Login/hello",method = RequestMethod.GET)
    R helloLocal();

}
