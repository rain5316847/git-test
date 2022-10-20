package com.example.workdaka.mapper.local;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.local.ThisUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<ThisUser> {

    List<HashMap<String,Object>> getMsg(@Param("id") String id);

}
