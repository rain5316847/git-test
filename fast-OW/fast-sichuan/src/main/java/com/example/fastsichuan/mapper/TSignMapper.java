package com.example.fastsichuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fastsichuan.entity.TSign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TSignMapper extends BaseMapper<TSign> {

    List<HashMap<String,Object>> getPackingSign(@Param("QRCode") String QRCode);

}
