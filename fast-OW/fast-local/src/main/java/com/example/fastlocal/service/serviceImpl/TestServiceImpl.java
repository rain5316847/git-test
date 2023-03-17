package com.example.fastlocal.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fastlocal.entity.TestCode;
import com.example.fastlocal.entity.ThisQueryUrl;
import com.example.fastlocal.mapper.TestCodeMapper;
import com.example.fastlocal.service.IQRCodeService;
import com.example.fastlocal.service.ITestCodeService;
import com.example.fastlocal.service.IThisQueryProductInfoService;
import com.example.fastlocal.service.IThisQueryUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TestServiceImpl extends ServiceImpl<TestCodeMapper, TestCode> implements ITestCodeService {

    @Autowired
    private IQRCodeService iqrCodeService;

    @Autowired
    private IThisQueryUrlService iThisQueryUrlService;


    @Override
    public List<TestCode> queryDmCode() {
        QueryWrapper<TestCode> testCodeQueryWrapper = new QueryWrapper<>();
        List<TestCode> codeList = baseMapper.selectList(testCodeQueryWrapper);
        List<TestCode> newList = new ArrayList<>();
        codeList.forEach( c->{
            String code = c.getCode();
            code = ("HTTP://AAX5.CN/B/"+code);
            System.out.println(code);
            try {
                JSONObject data = iqrCodeService.parseJSON(iqrCodeService.queryInfoWithCode(code));
                if (data != null){
                    log.info(data.toString());
                    Map map = JSON.parseObject(String.valueOf(data),Map.class);
                    if(map.get("dmCode")!= null){
                        c.setDmCode(this.getDmCode(data));
                    }
                    else {
                        c.setDmCode("null");
                    }
                }
                else {
                    c.setDmCode("null");
                }
                baseMapper.updateById(c);
                newList.add(c);
                log.info("=================c:{}==============",c);
            } catch (UnsupportedEncodingException e) {
                log.info("=================error:{}==============",code);
            }
        });
        return newList;
    }

    @Override
    public String getDmCode(JSONObject data) {
        String dmCode = data.getString("dmCode");
        return dmCode;
    }
}
