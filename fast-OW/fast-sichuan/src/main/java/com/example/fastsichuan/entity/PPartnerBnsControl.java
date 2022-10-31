package com.example.fastsichuan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("p_partner_bns_control")
public class PPartnerBnsControl {

    private String id;

    private String activityId;

    private String parentId;

    private String partnerId;

    private String productIds;

    private String balance;

    private String useBalance;

    private String total;

    private String useTotal;

    private String presetAmount;

    private String bnsType;

    private String empId;

    private String gmtCreate;

    private String gmtUpdate;

    private String status;

    @TableField(exist = false)
    private String dec;
}
