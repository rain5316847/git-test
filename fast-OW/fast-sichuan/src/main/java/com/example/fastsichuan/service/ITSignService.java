package com.example.fastsichuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastsichuan.entity.TSign;

import java.util.HashMap;
import java.util.List;

public interface ITSignService extends IService<TSign> {

    List<HashMap<String, Object>> getPackingSign(String QRCode);

}
