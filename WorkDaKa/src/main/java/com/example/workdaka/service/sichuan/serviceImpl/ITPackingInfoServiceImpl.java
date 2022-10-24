package com.example.workdaka.service.sichuan.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.local.ThisQueryProductInfo;
import com.example.workdaka.entity.sichuan.TPackingInfo;
import com.example.workdaka.mapper.local.ThisQueryProductInfoMapper;
import com.example.workdaka.mapper.sichuan.TPackingInfoMapper;
import com.example.workdaka.service.sichuan.ITPackingInfoService;
import com.example.workdaka.service.sichuan.ITSignService;
import com.example.workdaka.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ITPackingInfoServiceImpl extends ServiceImpl<TPackingInfoMapper, TPackingInfo> implements ITPackingInfoService {

    @Autowired
    private ITSignService itSignService;

    @Autowired
    private ThisQueryProductInfoMapper thisQueryProductInfoMapper;

    /**
    * 查询箱码关联信息
    * */
    @Override
    public R getPackingInfoMsg(String urlId) {

        R r = R.of();
        ThisQueryProductInfo thisQueryProductInfo;
        String QRCode = null;
        TPackingInfo tPackingInfo;
        String packingId = null;
        List<HashMap<String, Object>> tPackingList;
        List<HashMap<String, Object>> packingSign;

        try{
            thisQueryProductInfo = queryURLMsg(urlId);
            QRCode = thisQueryProductInfo.getQRCode();
            r.put("thisQueryProductInfo",thisQueryProductInfo);
        }catch (Exception e){
            if(e instanceof NullPointerException){
                r.error("数据不存在");
            }
            else {
                r.error();
                throw e;
            }
        }
        try {
            tPackingInfo = getPackingInfo(QRCode);
            packingId = tPackingInfo.getId();
            r.put("tPackingInfo",tPackingInfo);
        }catch (Exception e){
            if(e instanceof NullPointerException){
                r.error("数据不存在");
            }
            else {
                r.error();
                throw e;
            }
        }
        try {
            tPackingList = getPackingListWithPackingId(packingId);
            r.put("tPackingList",tPackingList);
        }catch (Exception e){
            if(e instanceof NullPointerException){
                r.error("数据不存在");
            }
            else {
                r.error();
                throw e;
            }
        }
        try {
            packingSign = getPackingSign(QRCode);
            r.put("packingSign",packingSign);
        }catch (Exception e){
            if(e instanceof NullPointerException){
                r.error("数据不存在");
            }
            else {
                r.error();
                throw e;
            }
        }

        return r;
    }

    /**
    * 根据箱码id查询其包含瓶子的信息
    * */
    @Override
    public List<HashMap<String, Object>> getPackingListWithPackingId(String packingId) {
        return baseMapper.getPackingListWithPackingId(packingId);
    }

    /**
    * 根据urlId在本地库查询二维码解析信息
    * */
    @Override
    public ThisQueryProductInfo queryURLMsg(String urlId) {
        QueryWrapper<ThisQueryProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("query_url_id",urlId);
        return thisQueryProductInfoMapper.selectOne(queryWrapper);
    }

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
