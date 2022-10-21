package com.example.workdaka.mapper.sichuan;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.sichuan.TSign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

@Mapper
public interface TSignMapper extends BaseMapper<TSign> {

    HashMap<String,Object> queryProductSign(@Param("packingCode") String packingCode);

}
