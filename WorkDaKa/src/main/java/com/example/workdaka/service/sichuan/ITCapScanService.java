package com.example.workdaka.service.sichuan;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.sichuan.TCapScan;

import java.util.Map;

public interface ITCapScanService extends IService<TCapScan> {

    Map<String,Object> queryCapScan(String code);

}
