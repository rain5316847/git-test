package com.example.workdaka.service.sichuan.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.sichuan.TCapScan;
import com.example.workdaka.mapper.sichuan.TCapScanMapper;
import com.example.workdaka.service.sichuan.ITCapScanService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ITCapScanServiceImpl extends ServiceImpl<TCapScanMapper, TCapScan> implements ITCapScanService {

    @Override
    public Map<String, Object> queryCapScan(String code) {
        return baseMapper.queryCapScan(code);
    }

}
