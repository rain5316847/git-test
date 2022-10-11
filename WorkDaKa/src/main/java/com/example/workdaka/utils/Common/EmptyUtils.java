package com.example.workdaka.utils.Common;

import com.example.workdaka.exceptions.BusinessJsonExceptions;

public class EmptyUtils {

    public static void strEmpty(String s,String msg) {
        strEmpty(s,"1001",msg);
    }

    public static void strEmpty(String s,String code,String msg){
        if(StrUtils.isBlankOrUndefined(s)){
            throw new BusinessJsonExceptions(msg,code);
        }
    }


}
