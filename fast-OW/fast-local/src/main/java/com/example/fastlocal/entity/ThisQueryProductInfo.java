package com.example.fastlocal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("this_query_product_info")
public class ThisQueryProductInfo {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String queryUrlId;

    /*
     * 产品类型（1：箱码；2：瓶码）
     * */
    private String productType;

    private String QRCode;

    private String dmCode;

    private String productCode;

    private String productName;

    private String time;

    public ThisQueryProductInfo(String queryUrlId,String productType,String QRCode){
        this.queryUrlId = queryUrlId;
        this.productType = productType;
        this.QRCode = QRCode;
    }

    public ThisQueryProductInfo(String queryUrlId,String productType,String QRCode,String dmCode,String productCode,String productName){
        this.queryUrlId = queryUrlId;
        this.productType = productType;
        this.QRCode = QRCode;
        this.dmCode = dmCode;
        this.productCode = productCode;
        this.productName = productName;
    }

    public static ThisQueryProductInfo create(String queryUrlId,String productType,String QRCode){
        return new ThisQueryProductInfo(queryUrlId,productType,QRCode);
    }

    public static ThisQueryProductInfo create(String queryUrlId,String productType,String QRCode,String dmCode,String productCode,String productName){
        return new ThisQueryProductInfo(queryUrlId,productType,QRCode,dmCode,productCode,productName);
    }

}
