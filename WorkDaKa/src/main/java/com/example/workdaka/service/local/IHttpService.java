package com.example.workdaka.service.local;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.local.ThisHttp;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface IHttpService extends IService<ThisHttp> {

    void getRequestMsg(HttpServletRequest httpServletRequest) throws IOException;

}
