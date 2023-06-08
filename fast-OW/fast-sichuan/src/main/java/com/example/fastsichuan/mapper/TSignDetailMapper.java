package com.example.fastsichuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fastsichuan.entity.TSignDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TSignDetailMapper extends BaseMapper<TSignDetail> {

    List<TSignDetail> getPackingSignDetail (@Param("epc") String epc);

    void updateTSignDetail(@Param("id") String id,@Param("epcs") String epcs);

}
