package com.example.fastsichuan.utils.common;

public class CharUtils {

    public static boolean isBlankChar(char c){
        return isBlankChar((int)c);
    }

    public static boolean isBlankChar(int c){
        return Character.isWhitespace(c)||Character.isSpaceChar(c)|| c == 65279 || c == 8234;
    }

}
