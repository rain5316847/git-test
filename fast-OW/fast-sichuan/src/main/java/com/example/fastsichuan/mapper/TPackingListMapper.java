package com.example.fastsichuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fastsichuan.entity.TPackingList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

@Mapper
public interface TPackingListMapper extends BaseMapper<TPackingList> {

    HashMap<String,Object> queryCapMsg(@Param("dmCode") String dmCode, @Param("productCode") String productCode);

}
