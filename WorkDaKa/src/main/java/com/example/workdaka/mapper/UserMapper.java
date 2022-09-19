package com.example.workdaka.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.ThisUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<ThisUser> {



}
