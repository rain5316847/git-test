package com.example.workdaka.service.sichuan.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.local.ThisQueryProductInfo;
import com.example.workdaka.entity.sichuan.TPackingInfo;
import com.example.workdaka.entity.sichuan.TPackingList;
import com.example.workdaka.mapper.local.ThisQueryProductInfoMapper;
import com.example.workdaka.mapper.sichuan.TPackingListMapper;
import com.example.workdaka.service.sichuan.ITPackingInfoService;
import com.example.workdaka.service.sichuan.ITPackingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ITPackingListServiceImpl extends ServiceImpl<TPackingListMapper, TPackingList> implements ITPackingListService {

    @Autowired
    private ThisQueryProductInfoMapper thisQueryProductInfoMapper;

    @Autowired
    private ITPackingInfoService itPackingInfoService;

    @Override
    public ThisQueryProductInfo queryURLMsg(String urlId) {
        QueryWrapper<ThisQueryProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("query_url_id",urlId);
        return thisQueryProductInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public TPackingList getOneTPackingListWithUrlId(String urlId){
        return this.getOneTPackingList(this.queryURLMsg(urlId).getDmCode());
    }

    @Override
    public TPackingList getOneTPackingList(String code) {
        QueryWrapper<TPackingList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code",code);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public TPackingInfo getPackingInfo(String urlId) {
        return itPackingInfoService.getPackingInfo(getOneTPackingListWithUrlId(urlId).getCode());
    }


}
