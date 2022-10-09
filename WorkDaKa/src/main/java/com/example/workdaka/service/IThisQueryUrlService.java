package com.example.workdaka.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.ThisQueryUrl;

public interface IThisQueryUrlService extends IService<ThisQueryUrl> {

    void insertQueryUrl(ThisQueryUrl thisQueryUrl);

}
