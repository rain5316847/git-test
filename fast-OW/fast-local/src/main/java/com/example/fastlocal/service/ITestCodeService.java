package com.example.fastlocal.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastlocal.entity.TestCode;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITestCodeService extends IService<TestCode> {

    List<TestCode> queryDmCode();

    String getDmCode(JSONObject data);

}
