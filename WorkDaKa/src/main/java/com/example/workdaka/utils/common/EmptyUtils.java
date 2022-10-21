package com.example.workdaka.utils.common;

import com.example.workdaka.entity.local.enumEntity.ShuYunProductName;
import com.example.workdaka.utils.exceptions.BusinessJsonExceptions;

public class EmptyUtils {

    public static void strEmpty(String s,String msg) {
        strEmpty(s,"1001",msg);
    }

    public static void strEmpty(String s,String code,String msg){
        if(StrUtils.isBlankOrUndefined(s)){
            throw new BusinessJsonExceptions(msg,code);
        }
    }

    public static String emptyMsg(String s,String msg){
        String name = null;
        if(msg.equals("p")){
            name = ShuYunProductName.p.getPName();
        }else if(msg.equals("c")){
            name = ShuYunProductName.c.getPName();
        }
        String str = name+"为"+s+"的数据在四川数据库（shuyun_stts_sc，172.16.61.12）中不存在！";
        return str;
    }


}
