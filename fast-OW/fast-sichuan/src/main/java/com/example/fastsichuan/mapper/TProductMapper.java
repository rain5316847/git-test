package com.example.fastsichuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fastsichuan.entity.TProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TProductMapper extends BaseMapper<TProduct> {

   // @Select("SELECT * from t_product a where a.id = #{id};")
   List<HashMap<String,Object>> getOneTProduct(@Param("id") String id);

}
