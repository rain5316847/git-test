package com.example.fasttest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_sign_detail")
public class TSignDetail {

    private String id;

    private String orderNo;

    private String productId;

    private String productCode;

    private String productName;

    private String productAmount;

    private String productCount;

    private String price;

    private String epcs;

    private String sellType;

    private String batchNo;

    private String gmtProduct;

    private String gmtFacture;

    private String place;

}
