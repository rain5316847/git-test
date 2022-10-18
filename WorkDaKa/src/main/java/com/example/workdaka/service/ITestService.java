package com.example.workdaka.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.Test;

import java.util.List;

public interface ITestService extends IService<Test> {

    List<Test> showAllTest();

}
