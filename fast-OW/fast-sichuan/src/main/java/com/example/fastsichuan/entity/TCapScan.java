package com.example.fastsichuan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@TableName("t_cap_scan")
public class TCapScan {

    private String id;

    private String scanNo;

    private String areaFirst;

    private String areaSecond;

    private String partnerNo;

    private String partnerName;

    private String terminalNo;

    private String terminalName;

    private String deliveryType;

    private String scanAmount;

    private String effectAmount;

    private String remark;

    private String gmtCreate;

    private String operId;

    private String operName;

    private String orgId;

    private String longitude;

    private String latitude;

    private String formattedAddress;

    private String province;

    private String city;

    private String district;

    private String street;;

    private String scanOperId;
}
