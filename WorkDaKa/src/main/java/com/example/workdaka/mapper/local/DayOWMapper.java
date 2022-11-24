package com.example.workdaka.mapper.local;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdaka.entity.local.excel.DayOW;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DayOWMapper extends BaseMapper<DayOW> {

    void insertDayOW(@Param("man")String man,
                     @Param("order_no")String orderNo,
                     @Param("epc")String epc,
                     @Param("problem")String problem,
                     @Param("solve")String solve,
                     @Param("is_fac")String isFac);

    DayOW getLastDayOW();

}
