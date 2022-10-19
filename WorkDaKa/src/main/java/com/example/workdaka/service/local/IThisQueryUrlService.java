package com.example.workdaka.service.local;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.local.ThisQueryUrl;

public interface IThisQueryUrlService extends IService<ThisQueryUrl> {

    void insertQueryUrl(ThisQueryUrl thisQueryUrl);

}
