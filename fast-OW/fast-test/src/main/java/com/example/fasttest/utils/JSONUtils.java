package com.example.fasttest.utils;

import com.alibaba.fastjson.JSON;

public class JSONUtils {

    public static String Object2String(Object object){
        return JSON.toJSONString(object);
    }

    public static Object String2Object(String str,Class object){
        return JSON.parseObject(str,object);
    }

}
