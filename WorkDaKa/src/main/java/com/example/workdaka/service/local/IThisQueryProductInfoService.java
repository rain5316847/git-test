package com.example.workdaka.service.local;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.local.ThisQueryProductInfo;

public interface IThisQueryProductInfoService extends IService<ThisQueryProductInfo> {

    void insertThisQueryProductInfo(ThisQueryProductInfo thisQueryProductInfo);

}
