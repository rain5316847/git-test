package com.example.workdaka.mapper.zhejiang;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.zhejiang.TSign;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("ZJTSignMapper")
public interface TSignMapper extends BaseMapper<TSign> {
}
