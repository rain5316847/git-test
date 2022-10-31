package com.example.fastsichuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fastsichuan.entity.TCapScan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

@Mapper
public interface TCapScanMapper extends BaseMapper<TCapScan> {

    HashMap<String,Object> queryCapScan(@Param("code") String code);

}
