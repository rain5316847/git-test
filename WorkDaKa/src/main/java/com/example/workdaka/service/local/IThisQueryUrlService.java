package com.example.workdaka.service.local;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.local.QueryQRCode;
import com.example.workdaka.entity.local.ThisQueryProductInfo;
import com.example.workdaka.entity.local.ThisQueryUrl;

import java.util.Map;

public interface IThisQueryUrlService extends IService<ThisQueryUrl> {

    void insertUrlAndInfo(Map<String,Object> data, QueryQRCode queryQRCode);

}
