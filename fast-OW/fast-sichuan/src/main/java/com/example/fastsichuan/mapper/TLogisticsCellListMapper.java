package com.example.fastsichuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fastsichuan.entity.TLogisticsCellList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TLogisticsCellListMapper extends BaseMapper<TLogisticsCellList> {

    @Select("SELECT * from t_logistics_cell_list a where a.logistics_id = #{logId}")
    List<TLogisticsCellList> getList (@Param("logId") String logId);

}
