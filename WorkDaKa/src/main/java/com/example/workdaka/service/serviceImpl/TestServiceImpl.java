package com.example.workdaka.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdaka.entity.Test;
import com.example.workdaka.mapper.shuyun.TestMapper;
import com.example.workdaka.service.ITestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {
    @Override
    public List<Test> showAllTest() {
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        List<Test> list = baseMapper.selectList(queryWrapper);
        return list;
    }
}
