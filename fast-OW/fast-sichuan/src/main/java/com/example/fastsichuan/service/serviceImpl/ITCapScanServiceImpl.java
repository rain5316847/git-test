package com.example.fastsichuan.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fastsichuan.entity.TCapScan;
import com.example.fastsichuan.mapper.TCapScanMapper;
import com.example.fastsichuan.service.ITCapScanService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ITCapScanServiceImpl extends ServiceImpl<TCapScanMapper, TCapScan> implements ITCapScanService {

    @Override
    public Map<String, Object> queryCapScan(String code) {
        return baseMapper.queryCapScan(code);
    }

}
