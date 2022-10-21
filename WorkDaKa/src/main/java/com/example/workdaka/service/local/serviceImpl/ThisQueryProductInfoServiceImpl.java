package com.example.workdaka.service.local.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.local.ThisQueryProductInfo;
import com.example.workdaka.mapper.local.ThisQueryProductInfoMapper;
import com.example.workdaka.service.local.IThisQueryProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ThisQueryProductInfoServiceImpl extends ServiceImpl<ThisQueryProductInfoMapper, ThisQueryProductInfo> implements IThisQueryProductInfoService {
    @Override
    public void insertThisQueryProductInfo(ThisQueryProductInfo thisQueryProductInfo) {
        log.info("=======================thisQueryProductInfo:{}=======================",thisQueryProductInfo);
        baseMapper.insert(thisQueryProductInfo);
    }
}
