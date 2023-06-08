package com.example.fastsichuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fastsichuan.entity.TLogisticsCellInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TLogisticsCellInfoMapper extends BaseMapper<TLogisticsCellInfo> {

    List<TLogisticsCellInfo> getInfoA();

}
