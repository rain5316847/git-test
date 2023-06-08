package com.example.fastsichuan.utils.common;

import com.example.fastsichuan.utils.exceptions.BusinessJsonExceptions;

public class EmptyUtils {

    public static boolean strEmpty(String s){
        return StrUtils.isBlankOrUndefined(s);
    }

    public static void strEmpty(String s,String msg) {
        strEmpty(s,"1001",msg);
    }

    public static void strEmpty(String s,String code,String msg){
        if(StrUtils.isBlankOrUndefined(s)){
            throw new BusinessJsonExceptions(msg,code);
        }
    }

    public static boolean objectEmpty(Object object){
        return ObjectUtils.objectEmpty(object);
    }


}
