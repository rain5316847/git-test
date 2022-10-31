package com.example.fastlocal.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private Map<String,Object> data;
    private String msg;
    private long reqtime;

    public static R newInstance(){
        R instance = new R();
        instance.setCode(0);
        instance.setMsg("请求成功");
        instance.setReqtime(System.currentTimeMillis());
        return instance;
    }

    public static R of() {
        return R.newInstance();
    }

    public R put(String key,Object value){
        if(this.data == null){
            this.data = new HashMap<String,Object>();
        }
        this.data.put(key,value);
        return this;
    }

    public R putAll (Map<String,Object> map){
        if(this.data == null){
            this.data = new HashMap<String,Object>();
        }
        this.data.putAll(map);
        return this;
    }

    public R error(){
        this.setCode(9999);
        this.setMsg("请求失败");
        return this;
    }

    public R error(String msg){
        this.setCode(9999);
        if (msg == null || msg.trim().length() == 0 || "null".equals(msg)) this.msg = "未知错误！";
        else {
            this.setMsg(msg);
        }
        return this;
    }

    public R error(int code,String msg){
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public R tokenFailure(){
        this.setCode(6666);
        this.setMsg("token已过期！");
        return this;
    }
}
