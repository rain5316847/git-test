package com.example.workdaka.service.local;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.local.excel.DayOW;

import java.util.Map;

public interface IDayOWService extends IService<DayOW> {

    void createDayOW(Map<String,String> data);

    void createDayFacOW(Map<String,Object> data);

    void testExcel();

}
