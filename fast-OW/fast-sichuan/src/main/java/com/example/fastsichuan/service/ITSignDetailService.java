package com.example.fastsichuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastsichuan.entity.TSignDetail;
import org.dom4j.DocumentException;

import java.io.IOException;

public interface ITSignDetailService extends IService<TSignDetail> {

    void updateEpcS(String epc);

    void setTSignDetailToXML(String id,String epcs) throws DocumentException, IOException;

    void updateAll();
}
