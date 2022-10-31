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
@TableName("t_cap_scan_detail")
public class TCapScanDetail{

    private String id;

    private String capScanId;

    private String productCode;

    private String productName;

    private String policyId;

    private String priceNo;

    private String price;

    private String coupon;

    private String inCode;

    private String scanStatus;

    private String remark;

    private String awardName;

    private String awardType;

    private String exchangeAwardName;

    private String prizeMemberId;

    private String prizeNickname;

    private String scanRecordId;

    private String balance;

    private String tradePartnerNo;

    private String tradePartnerName;

    private String tradeId;

    private String gmtTrade;

    private String relationId;

    private String integral;

    private String fullInCode;

    private String awardId;
}
