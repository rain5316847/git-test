package com.example.fastsichuan;

import com.example.fastremote.remote.FastTestRemote;
import com.example.fastsichuan.service.IThisQueryProductInfoService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootTest
class FastSichuanApplicationTests {

    @Autowired
    private IThisQueryProductInfoService iThisQueryProductInfoService;

    @Autowired
    private FastTestRemote fastTestRemote;

    @Test
    void contextLoads() {

        System.out.println(iThisQueryProductInfoService.getInfo("1443d874af190cd06a1f786479c208"));
        //System.out.println(fastTestRemote.hello());
    }

    @Test
    void test() throws DocumentException, IOException {
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
        Id.setText("id");
        Epcs.setText("epcs");
        // 创建一种输出格式    每个节点元素可自动换行
        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter=new XMLWriter(new FileWriter(file),outputFormat);//写入XML文件的位置 以及指定的格式
        xmlWriter.write(read);//开始写入XML文件   写入Document对象
        xmlWriter.close();
    }

}
