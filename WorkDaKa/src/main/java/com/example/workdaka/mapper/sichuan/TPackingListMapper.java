package com.example.workdaka.mapper.sichuan;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.sichuan.TPackingList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TPackingListMapper extends BaseMapper<TPackingList> {

    HashMap<String,Object> queryCapMsg(@Param("dmCode") String dmCode, @Param("productCode") String productCode);

    List<HashMap<String,Object>> getOneList(@Param("code") String code);

    List<HashMap<String,Object>> getMsgWithCode(@Param("code") String code);


}
