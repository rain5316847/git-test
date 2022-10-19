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
@TableName("t_sign")
public class TSign {

    private String id;

    private String orderNo;

    private String relationNo;

    private String node;

    private String srcPartnerId;

    private String srcPartnerNo;

    private String srcPartnerName;

    private String tarPartnerId;

    private String tarPartnerNo;

    private String tarPartnerName;

    private String productAmount;

    private String longitude;

    private String latitude;

    private String areaFirstId;

    private String areaFirstName;

    private String areaSecondId;

    private String areaSecondName;

    private String areaThreeId;

    private String areaThreeName;

    private String signDate;;

    private String gmtScan;

    private String operId;

    private String sellType;

    private String gmtCreate;

    private String gmtUpdate;

    private String upSnowStatus;

    private String outPartnerNo;

    private String address;

}
