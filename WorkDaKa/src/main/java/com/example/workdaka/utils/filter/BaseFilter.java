package com.example.workdaka.utils.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "baseFilter",urlPatterns = "/*")
public class BaseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        log.info("-------{}过滤器初始化-------",this.getClass().getSimpleName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("-------{}过滤器处理请求-------",this.getClass().getSimpleName());
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //此时request中的body已经变成了String类型
        MultiReadHttpServletRequestWrapper multiReadHttpServletRequestWrapper = new MultiReadHttpServletRequestWrapper(httpServletRequest);
        log.info("multiReadHttpServletRequestWrapper:{}",multiReadHttpServletRequestWrapper.body);
        //获取请求中的流转换为字符串，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
        //在chain.doFiler方法中传递新的request对象
        //最后加载到过滤器链路中
        filterChain.doFilter(multiReadHttpServletRequestWrapper, servletResponse);
    }

    public void destroy(){
        log.info("-------{}过滤器销毁-------",this.getClass().getSimpleName());
    }
}
