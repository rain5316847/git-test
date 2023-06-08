package com.example.fastsichuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fastsichuan.entity.TSign;
import com.example.fastsichuan.mapper.TSignMapper;
import com.example.fastsichuan.service.ITSignService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ITSignServiceImpl extends ServiceImpl<TSignMapper, TSign> implements ITSignService {


    @Override
    public List<HashMap<String, Object>> getPackingSign(String QRCode) {
        List<HashMap<String, Object>> packingSign = baseMapper.getPackingSign(QRCode);
        return packingSign;
    }



}
