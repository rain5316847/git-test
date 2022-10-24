package com.example.workdaka.service.sichuan.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.local.ThisQueryProductInfo;
import com.example.workdaka.entity.sichuan.TPackingInfo;
import com.example.workdaka.entity.sichuan.TPackingList;
import com.example.workdaka.mapper.local.ThisQueryProductInfoMapper;
import com.example.workdaka.mapper.sichuan.TPackingListMapper;
import com.example.workdaka.service.sichuan.ITCapScanService;
import com.example.workdaka.service.sichuan.ITPackingInfoService;
import com.example.workdaka.service.sichuan.ITPackingListService;
import com.example.workdaka.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ITPackingListServiceImpl extends ServiceImpl<TPackingListMapper, TPackingList> implements ITPackingListService {

    @Autowired
    private ThisQueryProductInfoMapper thisQueryProductInfoMapper;

    @Autowired
    private ITPackingInfoService itPackingInfoService;

    @Autowired
    private ITCapScanService itCapScanService;

    @Override
    public R getCapMsg(String urlId) {

        R r = R.of();

        ThisQueryProductInfo thisQueryProductInfo = queryURLMsg(urlId);
        String dmCode = thisQueryProductInfo.getDmCode();
        String QRCode = thisQueryProductInfo.getQRCode();

        TPackingList tPackingList = getOneTPackingList(dmCode);
        String packingInfoId = tPackingList.getPackingInfoId();
        TPackingInfo tPackingInfo = getPackingInfoWithId(packingInfoId);
        String packingCode = tPackingInfo.getEpc();
        List<HashMap<String, Object>> packingSign = getPackingSign(packingCode);
        Map<String,Object> tCapScanAndDetail = getCapScan(QRCode);

        r.put("thisQueryProductInfo",thisQueryProductInfo);
        r.put("tPackingList",tPackingList);
        r.put("tPackingInfo",tPackingInfo);
        r.put("tCapScanAndDetail",tCapScanAndDetail);
        r.put("packingSign",packingSign);

        return r;
    }

    @Override
    public List<HashMap<String, Object>> getPackingSign(String packingCode) {
        return itPackingInfoService.getPackingSign(packingCode);
    }

    @Override
    public List<HashMap<String, Object>> getPackingSignWithUrlId(String urlId) {
        return itPackingInfoService.getPackingSign(queryURLMsg(urlId).getQRCode());
    }

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
    public TPackingList getOneTPackingList(String dmCode) {
        QueryWrapper<TPackingList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code",dmCode);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public TPackingInfo getPackingInfoWithUrlId(String urlId) {
        return getPackingInfoWithId(getOneTPackingListWithUrlId(urlId).getPackingInfoId());
    }

    @Override
    public TPackingInfo getPackingInfoWithId(String id) {
        return itPackingInfoService.getPackingInfoWithId(id);
    }

    @Override
    public Map<String, Object> getCapScanWithUrlId(String urlId) {
        return getCapScan(queryURLMsg(urlId).getQRCode());
    }

    @Override
    public Map<String, Object> getCapScan(String QRCode) {
        return itCapScanService.queryCapScan(QRCode);
    }


}
