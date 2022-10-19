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
@TableName("p_partner")
public class PPartner {

    private String id;

    private String no;

    private String name;

    private String shortName;

    private String type;

    private String areaCode;

    private String areaName;

    private String address;

    private String linkman;

    private String mobile;

    private String telephone;

    private String areaFirstId;

    private String areaFirstName;

    private String areaSecondId;

    private String areaSecondName;

    private String areaThreeId;

    private String areaThreeName;

    private String typeFirst;

    private String typeSecond;

    private String hot;

    private String status;

    private String longitude;

    private String latitude;

    private String operId;

    private String operName;

    private String gmtCreate;

    private String gmtUpdate;

    private String waiterMaxAmount;

    private String areaCom;

    private String areaComName;

    private String marketingCenter;

    private String marketingCenterName;

    private String marketingCenterId;

    private String attributes;

    private String autoSign;

    private String deleted;
}
