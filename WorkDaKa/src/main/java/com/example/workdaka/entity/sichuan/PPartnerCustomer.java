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
@TableName("p_partner_customer")
public class PPartnerCustomer {

    private String id;

    private String partnerId;

    private String customerId;

    private String operId;

    private String operName;

    private String gmtCreate;

    private String gmtUpdate;

    private String productIds;

    private String autoSign;
}
