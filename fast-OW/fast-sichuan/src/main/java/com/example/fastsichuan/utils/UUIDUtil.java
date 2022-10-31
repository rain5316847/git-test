package com.example.fastsichuan.utils;

import java.util.UUID;

/**
* 雪花算法生成，适用于关联表主键生成
* */
public class UUIDUtil {
    public static String createUUId(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}

