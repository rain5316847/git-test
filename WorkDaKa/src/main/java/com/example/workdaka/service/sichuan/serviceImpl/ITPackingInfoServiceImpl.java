package com.example.workdaka.service.sichuan.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.sichuan.TPackingInfo;
import com.example.workdaka.mapper.sichuan.TPackingInfoMapper;
import com.example.workdaka.service.sichuan.ITPackingInfoService;
import com.example.workdaka.service.sichuan.ITSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ITPackingInfoServiceImpl extends ServiceImpl<TPackingInfoMapper, TPackingInfo> implements ITPackingInfoService {

    @Autowired
    private ITSignService itSignService;

    /**
    * 根据箱码查询箱子本身信息
    * */
    @Override
    public TPackingInfo getPackingInfo(String code) {
        return baseMapper.getPackingInfo(code);
    }

    /**
     * 根据箱码id查询箱子本身信息
     * */
    @Override
    public TPackingInfo getPackingInfoWithId(String id) {
        return baseMapper.getPackingInfoWithId(id);
    }

    /**
    * 根据箱码查询此箱物流信息，包括签到记录和订单信息.
    *
     * */
    @Override
    public List<HashMap<String, Object>> getPackingSign(String code){
        return itSignService.getPackingSign(code);
    }
}
