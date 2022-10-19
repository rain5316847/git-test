package com.example.workdaka.mapper.zhejiang;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.zhejiang.TSignDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("ZJTSignDetailMapper")
public interface TSignDetailMapper extends BaseMapper<TSignDetail> {
}
