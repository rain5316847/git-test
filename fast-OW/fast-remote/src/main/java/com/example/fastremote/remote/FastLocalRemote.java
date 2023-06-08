package com.example.fastremote.remote;

import com.example.fastremote.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="fast-local",url = "http://172.18.21.38:8080",fallback = FastLocalRemoteHystrix.class)
public interface FastLocalRemote {

    @RequestMapping(value = "/local/QRCode/getQRMsgWithId",method = RequestMethod.POST)
    R getQRMsgWithId (String id);

}
