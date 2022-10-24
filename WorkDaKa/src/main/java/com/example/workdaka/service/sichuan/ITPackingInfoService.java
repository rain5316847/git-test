package com.example.workdaka.service.sichuan;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.sichuan.TPackingInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ITPackingInfoService extends IService<TPackingInfo> {

    TPackingInfo getPackingInfo (String code);

    TPackingInfo getPackingInfoWithId (String id);

    List<HashMap<String, Object>> getPackingSign(String code);

}
