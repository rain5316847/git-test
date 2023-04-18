package com.example.fasttest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fasttest.entity.PPartner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PPartnerMapper extends BaseMapper<PPartner> {

    @Select("SELECT * from p_partner a where a.id = #{id}")
    PPartner getPartner(@Param("id") String id);
}
