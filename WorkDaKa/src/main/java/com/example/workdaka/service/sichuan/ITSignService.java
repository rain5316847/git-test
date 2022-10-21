package com.example.workdaka.service.sichuan;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.sichuan.TSign;

import java.util.Map;

public interface ITSignService extends IService<TSign> {

    Map<String,Object> queryProductSign(String packingCode);

}
