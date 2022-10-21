package com.example.workdaka.service.sichuan;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.sichuan.TPackingInfo;
import com.example.workdaka.utils.R;

public interface ITPackingInfoService extends IService<TPackingInfo> {

    TPackingInfo getPackingInfo (String code);

    R getPackingSign(String code);

}
