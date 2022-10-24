package com.example.workdaka.service.sichuan.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.sichuan.TSign;
import com.example.workdaka.mapper.sichuan.TSignMapper;
import com.example.workdaka.service.sichuan.ITSignService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ITSignServiceImpl extends ServiceImpl<TSignMapper, TSign> implements ITSignService {


    @Override
    public List<HashMap<String, Object>> getPackingSign(String QRCode) {
        List<HashMap<String, Object>> packingSign = baseMapper.getPackingSign(QRCode);
        return packingSign;
    }

}
