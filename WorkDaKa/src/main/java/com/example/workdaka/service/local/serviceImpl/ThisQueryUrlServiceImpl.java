package com.example.workdaka.service.local.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.local.ThisQueryUrl;
import com.example.workdaka.mapper.local.ThisQueryUrlMapper;
import com.example.workdaka.service.local.IThisQueryUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ThisQueryUrlServiceImpl extends ServiceImpl<ThisQueryUrlMapper, ThisQueryUrl> implements IThisQueryUrlService {

    @Override
    public void insertQueryUrl(ThisQueryUrl thisQueryUrl) {
        log.info("thisQueryUrl:{}",thisQueryUrl);
        baseMapper.insert(thisQueryUrl);
    }

}
