package com.example.fastlocal.utils.common;

import com.example.fastlocal.entity.enumEntity.ShuYunProductName;
import com.example.fastlocal.utils.exceptions.BusinessJsonExceptions;

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

    public static String emptyMsg(String s,String msg){
        String name = null;
        if(msg.equals("p")){
            name = ShuYunProductName.p.getPName();
        }else if(msg.equals("c")){
            name = ShuYunProductName.c.getPName();
        }
        return name+"为"+s+"的数据在四川数据库（shuyun_stts_sc，172.16.61.12）中不存在！";
    }


}
