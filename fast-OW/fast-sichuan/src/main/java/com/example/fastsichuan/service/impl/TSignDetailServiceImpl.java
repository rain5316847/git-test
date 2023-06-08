package com.example.fastsichuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fastsichuan.entity.TLogisticsCellInfo;
import com.example.fastsichuan.entity.TLogisticsCellList;
import com.example.fastsichuan.entity.TSignDetail;
import com.example.fastsichuan.mapper.TLogisticsCellInfoMapper;
import com.example.fastsichuan.mapper.TLogisticsCellListMapper;
import com.example.fastsichuan.mapper.TSignDetailMapper;
import com.example.fastsichuan.service.ITSignDetailService;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TSignDetailServiceImpl extends ServiceImpl<TSignDetailMapper, TSignDetail> implements ITSignDetailService {

    @Autowired
    private TLogisticsCellInfoMapper TLogisticsCellInfoMapper;
    @Autowired
    private TLogisticsCellListMapper TLogisticsCellListMapper;

    @Override
    public void updateEpcS(String epc) {
        List<TSignDetail> detailList = baseMapper.getPackingSignDetail(epc);
        if(detailList.size() !=0) {
            detailList.forEach(a ->{
                String epcs = a.getEpcs().replaceAll(epc+",","");
                baseMapper.updateTSignDetail(a.getId(),epcs);
            });
        }
    }

    @Override
    public void setTSignDetailToXML(String id, String epcs) throws DocumentException, IOException {
        File file = new File("D://TSignDeTail/"+"123"+".xml");
        Document read;
        Element root;
        if (file.exists()){
            SAXReader reader=new SAXReader();
            read = reader.read("D://TSignDeTail/"+"123"+".xml");
            //得到根节点
            root = read.getRootElement();
        }else {
            read = DocumentHelper.createDocument();
            //给文档添加第一个节点（根节点）
            root = read.addElement("root");
            root.addAttribute("version", "2.0");
        }
        Element tSignDetail = root.addElement("tSignDetail");
        Element Id = tSignDetail.addElement("Id");
        Element Epcs = tSignDetail.addElement("Epcs");
        Id.setText(id);
        Epcs.setText(epcs);
        // 创建一种输出格式    每个节点元素可自动换行
        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter=new XMLWriter(new FileWriter(file),outputFormat);//写入XML文件的位置 以及指定的格式
        xmlWriter.write(read);//开始写入XML文件   写入Document对象
        xmlWriter.close();
    }

    @Override
    @Transactional
    public void updateAll() {

        ArrayList<String> arrayList = new ArrayList<>();
        List<TLogisticsCellInfo> logisticsCellInfoList = TLogisticsCellInfoMapper.getInfoA();
        logisticsCellInfoList.forEach(a->{
            List<TLogisticsCellList> logisticsCellListList = TLogisticsCellListMapper.getList(a.getId());
            logisticsCellListList.forEach(b->{
                List<TSignDetail> detailList = baseMapper.getPackingSignDetail(b.getPackingEpc());
                if(detailList.size() != 0){
                    detailList.forEach(c->{
                        if(!arrayList.contains(c.getId())){
                            arrayList.add(c.getId());
                            try {
                                this.setTSignDetailToXML(c.getId(),c.getEpcs());
                                log.info("======写入xml，tSignDetailId:{}=======",c.getId());
                            } catch (DocumentException | IOException e) {
                                e.printStackTrace();
                            }
                        }else {
                            String epcs = c.getEpcs().replaceAll(b.getPackingEpc()+",","");
                            baseMapper.updateTSignDetail(c.getId(),epcs);
                        }
                        log.info("=======logInfoId:{},logListId:{},tSignDetailId:{}========",a.getId(),b.getId(),c.getId());
                    });
                }
            });
        });

    }


}
