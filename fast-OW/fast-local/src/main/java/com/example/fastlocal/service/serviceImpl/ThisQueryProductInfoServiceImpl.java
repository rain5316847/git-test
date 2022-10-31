package com.example.fastlocal.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fastlocal.entity.ThisQueryProductInfo;
import com.example.fastlocal.mapper.ThisQueryProductInfoMapper;
import com.example.fastlocal.service.IThisQueryProductInfoService;
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
