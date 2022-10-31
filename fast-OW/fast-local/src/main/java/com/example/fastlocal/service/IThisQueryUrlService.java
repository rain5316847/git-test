package com.example.fastlocal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastlocal.entity.QueryQRCode;
import com.example.fastlocal.entity.ThisQueryUrl;

import java.util.Map;

public interface IThisQueryUrlService extends IService<ThisQueryUrl> {

    String insertUrlAndInfo(Map<String,Object> data, QueryQRCode queryQRCode);

}
