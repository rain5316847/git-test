package com.example.fastsichuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastsichuan.entity.TCapScan;

import java.util.Map;

public interface ITCapScanService extends IService<TCapScan> {

    Map<String,Object> queryCapScan(String code);

}
