package com.example.workdaka.utils.common;


public class StrUtils {

    public static boolean isBlankOrUndefined(CharSequence s){
        return isBlank(s) || isUndefined(s);
    }

    public static boolean isBlank(CharSequence s){
        if(s.length() != 0){
            for(int i=0;i<s.length();++i){
                if(!(CharUtils.isBlankChar(s.charAt(i)))){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUndefined(CharSequence s) {
        String strString = s.toString().trim();
        return "null".equals(strString) || "undefined".equals(strString);
    }

}
