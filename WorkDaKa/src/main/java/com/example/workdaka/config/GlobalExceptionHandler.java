package com.example.workdaka.config;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//配置全局捕获异常，@RestControllerAdvice会将该类运用到所有@RequestMapping中。
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (msg != null || !(msg.equals(""))) {
            msg = "服务器出错";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1000);
        jsonObject.put("message", msg);
        return jsonObject;
    }

}
