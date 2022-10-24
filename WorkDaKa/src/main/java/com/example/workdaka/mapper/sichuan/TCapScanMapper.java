package com.example.workdaka.mapper.sichuan;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.sichuan.TCapScan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

@Mapper
public interface TCapScanMapper extends BaseMapper<TCapScan> {

    HashMap<String,Object> queryCapScan(@Param("code") String code);

}
