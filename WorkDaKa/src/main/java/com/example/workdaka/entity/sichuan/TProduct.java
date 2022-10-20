package com.example.workdaka.entity.sichuan;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_product")
public class TProduct {

    private String id;

    private String gtin;

    private String shortGtin;

    private String series;

    private String brand;

    private String brandId;

    private String productCode;

    private String productType;

    private String relatedType;

    private String packingExternalAmount;

    private String packingExternalSpec;

    private String name;

    private String shortName;

    private String banner;

    private String img;

    private String unit;

    private String packingAmount;

    private String packingSpec;

    private String termValidity;

    private String retailPrice;

    private String decription;

    private String gmtCreate;

    private String gmtUpdate;

    private String status;

    private String relation;

    private String volume;

    private String grade;

    private String updatePersonId;

    private String updatePersonName;

    private String haveQrcode;

}
