package com.example.fastremote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThisQueryProductInfo implements Serializable {

    private static final long serialVersionUID = -1L;

    private String id;

    private String queryUrlId;

    /*
     * 产品类型（1：箱码；2：瓶码）
     * */
    private String productType;

    private String QRCode;

    private String parent;

    private String productId;

    private String produceTime;

    private String dmCode;

    private String storeCode;

    private String storeName;

    private String productCode;

    private String productName;

    private String time;

    public ThisQueryProductInfo(String queryUrlId, String productType, String QRCode){
        this.queryUrlId = queryUrlId;
        this.productType = productType;
        this.QRCode = QRCode;
    }

    public ThisQueryProductInfo(String queryUrlId, String productType, String QRCode, String parent,
                                String productId, String produceTime, String dmCode, String storeCode, String storeName,
                                String productCode, String productName){
        this.queryUrlId = queryUrlId;
        this.productType = productType;
        this.QRCode = QRCode;
        this.parent = parent;
        this.productId = productId;
        this.produceTime = produceTime;
        this.dmCode = dmCode;
        this.storeCode = storeCode;
        this.storeName = storeName;
        this.productCode = productCode;
        this.productName = productName;
    }

    public static ThisQueryProductInfo create(String queryUrlId,String productType,String QRCode){
        return new ThisQueryProductInfo(queryUrlId,productType,QRCode);
    }

    public static ThisQueryProductInfo create(String queryUrlId,String productType,String QRCode,String parent,
                                              String productId,String produceTime,String dmCode,String storeCode,String storeName,
                                              String productCode,String productName){
        return new ThisQueryProductInfo(queryUrlId,productType,QRCode,parent,productId,produceTime,dmCode, storeCode,storeName,productCode,productName);
    }

}
