package com.example.workdaka.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.ThisHttp;
import com.example.workdaka.mapper.HttpMapper;
import com.example.workdaka.service.IHttpService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@Service
@Aspect
public class HttpServiceImpl extends ServiceImpl<HttpMapper, ThisHttp> implements IHttpService {

    @Override
    public void getRequestMsg(HttpServletRequest httpServletRequest) throws IOException {

        //读取request的body，核心思路：获取请求中的流（request的body）转换为字符串，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
        BufferedReader reader = httpServletRequest.getReader();
        String line;
        String params = null;//返回请求行中的参数部分
        if(null != (line = reader.readLine())){
             params = line;
        }

        log.info("---------------httpRequest是:{}--------------",httpServletRequest);

        String ServerName = httpServletRequest.getServerName();//返回服务器的主机名
        int ServerPort = httpServletRequest.getServerPort();//返回服务器的端口号
        String uri = httpServletRequest.getRequestURI();//返回请求行中的资源名称
        String url = httpServletRequest.getRequestURL().toString();//获得客户端发送请求的完整url
        String ip = httpServletRequest.getRemoteAddr();//返回发出请求的IP地址
        String host=httpServletRequest.getRemoteHost();//返回发出请求的客户机的主机名
        int port =httpServletRequest.getRemotePort();//返回发出请求的客户机的端口号

        ThisHttp thisHttp = new ThisHttp();

        thisHttp.setRequestUri(uri);
        thisHttp.setRequestUrl(url);
        thisHttp.setRemoteAddr(ip);
        thisHttp.setRemoteHost(host);
        thisHttp.setQueryString(params);
        thisHttp.setServePort(String.valueOf(ServerPort));
        thisHttp.setServeName(ServerName);
        thisHttp.setRemotePort(String.valueOf(port));

        baseMapper.insert(thisHttp);

    }
}
