package com.example.workdaka.mapper.sichuan;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.sichuan.TProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TProductMapper extends BaseMapper<TProduct> {

   // @Select("SELECT * from t_product a where a.id = #{id};")
   List<HashMap<String,Object>> getOneTProduct(@Param("id") String id);

}
