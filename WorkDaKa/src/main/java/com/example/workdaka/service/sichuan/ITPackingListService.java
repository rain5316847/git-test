package com.example.workdaka.service.sichuan;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.local.ThisQueryProductInfo;
import com.example.workdaka.entity.sichuan.TPackingInfo;
import com.example.workdaka.entity.sichuan.TPackingList;

public interface ITPackingListService extends IService<TPackingList> {

    ThisQueryProductInfo queryURLMsg(String urlId);

    TPackingList getOneTPackingListWithUrlId(String urlId);

    TPackingList getOneTPackingList(String code);

    TPackingInfo getPackingInfo(String urlId);

}
