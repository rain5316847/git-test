package com.example.workdaka.service.sichuan.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.sichuan.TPackingInfo;
import com.example.workdaka.mapper.sichuan.TPackingInfoMapper;
import com.example.workdaka.service.sichuan.ITPackingInfoService;
import com.example.workdaka.utils.R;
import org.springframework.stereotype.Service;

@Service
public class ITPackingInfoServiceImpl extends ServiceImpl<TPackingInfoMapper, TPackingInfo> implements ITPackingInfoService {

    @Override
    //根据箱码查询箱子本身信息
    public R getPackingInfo(String code) {
        R r = R.of();
        TPackingInfo tPackingInfo = baseMapper.getPackingInfo(code);
        r.put("result",tPackingInfo);
        return r;
    }

    @Override
    /*
     * 根据箱码查询此箱物流信息，包括签到记录和订单信息。四川不做此查询
     * */
    public R getPackingSign(String code){
        return null;
    }
}
