package com.example.workdaka.service.local.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.workdaka.entity.local.excel.DayOW;
import com.example.workdaka.mapper.local.DayOWMapper;
import com.example.workdaka.mapper.sichuan.TPackingInfoMapper;
import com.example.workdaka.service.local.IDayOWService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DayOWServiceImpl extends ServiceImpl<DayOWMapper, DayOW> implements IDayOWService {

    @Autowired
    TPackingInfoMapper tPackingInfoMapper;

    @Override
    public void createDayOW(Map<String, String> data) {
        baseMapper.insertDayOW(
                data.get("man"),
                data.get("orderNo"),
                data.get("epc"),
                data.get("problem"),
                data.get("solve"),
                data.get("isFac"));
        DayOW dayOW = baseMapper.getLastDayOW();
        log.info("============dayOW:{}============",dayOW);
        HashMap<String,String> productData = tPackingInfoMapper.getDayExcelInfo(dayOW.getEpc());
        SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
        Date dateD = new Date(System.currentTimeMillis());
        String date = formatter.format(dateD);
        log.info("============date:{}============",date);

    }

    @Override
    public void createDayFacOW(Map<String, Object> data) {

    }

    @Override
    public void testExcel() {
        String fileName = "E:\\shuyun\\每日问题\\工厂出库问题统计-2022-11-23.xlsx";
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("sheet1");
            HSSFRow row0 = sheet.createRow(0);
            row0.createCell(0).setCellValue("第一列");
            row0.createCell(1).setCellValue("第二列");
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
