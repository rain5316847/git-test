package com.example.fastsichuan.service;


import com.example.fastsichuan.entity.ThisQueryProductInfo;

public interface IThisQueryProductInfoService {

    ThisQueryProductInfo getInfo(String id);

    ThisQueryProductInfo getInfoFromRedis(String id);

    void setInfoToRedis(ThisQueryProductInfo thisQueryProductInfo);

    ThisQueryProductInfo getInfoFromFastLocal(String id);

}
