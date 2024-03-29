package com.example.fastsichuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastsichuan.entity.TPackingInfo;
import com.example.fastsichuan.entity.ThisQueryProductInfo;
import com.example.fastsichuan.utils.R;

import java.util.HashMap;
import java.util.List;

public interface ITPackingInfoService extends IService<TPackingInfo> {

    R getPackingInfoMsg(String urlId);

    List<HashMap<String,Object>> getPackingListWithPackingId(String packingId);

    ThisQueryProductInfo queryURLMsg(String urlId);

    TPackingInfo getPackingInfo (String code);

    TPackingInfo getPackingInfoWithId (String id);

    List<HashMap<String, Object>> getPackingSign(String code);

}
