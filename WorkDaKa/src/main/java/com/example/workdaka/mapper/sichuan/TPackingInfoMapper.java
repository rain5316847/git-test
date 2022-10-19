package com.example.workdaka.mapper.sichuan;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.sichuan.TPackingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TPackingInfoMapper extends BaseMapper<TPackingInfo> {

    @Select("SELECT * FROM t_packing_info WHERE epc = #{code};")
    TPackingInfo getPackingInfo(@Param("code") String code);

}
