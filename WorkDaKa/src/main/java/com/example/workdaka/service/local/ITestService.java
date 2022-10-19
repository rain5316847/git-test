package com.example.workdaka.service.local;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.zhejiang.Test;

import java.util.List;

public interface ITestService extends IService<Test> {

    List<Test> showAllTest();

}
