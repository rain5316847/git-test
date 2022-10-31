package com.example.fastlocal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastlocal.entity.ThisQueryProductInfo;

public interface IThisQueryProductInfoService extends IService<ThisQueryProductInfo> {

    void insertThisQueryProductInfo(ThisQueryProductInfo thisQueryProductInfo);

}
