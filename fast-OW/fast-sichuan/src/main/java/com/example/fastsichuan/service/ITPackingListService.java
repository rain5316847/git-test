package com.example.fastsichuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastsichuan.entity.ThisQueryProductInfo;
import com.example.fastsichuan.entity.TPackingInfo;
import com.example.fastsichuan.entity.TPackingList;
import com.example.fastsichuan.utils.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ITPackingListService extends IService<TPackingList> {

    R getCapMsg(String urlId);

    List<HashMap<String, Object>> getPackingSign(String packingCode);

    List<HashMap<String, Object>> getPackingSignWithUrlId(String urlId);

    ThisQueryProductInfo queryURLMsg(String urlId);

    TPackingList getOneTPackingListWithUrlId(String urlId);

    TPackingList getOneTPackingList(String code);

    TPackingInfo getPackingInfoWithId(String urlId);

    TPackingInfo getPackingInfoWithUrlId(String dMCode);

    Map<String,Object> getCapScanWithUrlId(String urlId);

    Map<String,Object> getCapScan(String code);

}
