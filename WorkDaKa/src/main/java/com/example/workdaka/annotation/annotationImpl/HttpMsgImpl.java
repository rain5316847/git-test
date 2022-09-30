package com.example.workdaka.annotation.annotationImpl;

import com.example.workdaka.service.IHttpService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Aspect
@Component
public class HttpMsgImpl {

    @Autowired
    private IHttpService iHttpService;

    /*@After("@annotation(HttpMsg)")
    public void getHttpMsg(HttpServletRequest httpServletRequest) throws IOException {
        iHttpService.getRequestMsg(httpServletRequest);
    }*/
}
