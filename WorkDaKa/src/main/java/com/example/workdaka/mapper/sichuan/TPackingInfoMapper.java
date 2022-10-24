package com.example.workdaka.mapper.sichuan;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.sichuan.TPackingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TPackingInfoMapper extends BaseMapper<TPackingInfo> {

    @Select("SELECT * FROM t_packing_info WHERE epc = #{code};")
    TPackingInfo getPackingInfo(@Param("code") String code);

    @Select("SELECT * FROM t_packing_info WHERE id = #{id}")
    TPackingInfo getPackingInfoWithId(@Param("id") String id);

    List<HashMap<String, Object>> getPackingListWithPackingId(@Param("packingId") String packingId);

}
