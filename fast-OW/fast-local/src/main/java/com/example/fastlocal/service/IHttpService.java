package com.example.fastlocal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastlocal.entity.ThisHttp;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface IHttpService extends IService<ThisHttp> {

    void getRequestMsg(HttpServletRequest httpServletRequest) throws IOException;

}
