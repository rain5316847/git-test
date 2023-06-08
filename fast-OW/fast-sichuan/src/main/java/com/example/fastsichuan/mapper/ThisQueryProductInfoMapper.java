package com.example.fastsichuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fastsichuan.entity.ThisQueryProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ThisQueryProductInfoMapper extends BaseMapper<ThisQueryProductInfo> {

    @Select("SELECT b.* from this_query_url a,this_query_product_info b where a.id = b.query_url_id and a.id = #{id}")
    ThisQueryProductInfo getQRMsgWithId (@Param("id") String id);

}
