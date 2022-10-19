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
@TableName("t_packing_info")
public class TPackingInfo {

    private String id;

    private String productLineId;

    private String productId;

    private String orbit;

    private String epc;

    private String amount;

    private String codeAmount;

    private String realAmount;

    private String gmtScan;

    private String batchNo;

    private String team;

    private String gmtDate;

    private String gmtConfirm;

    private String orgId;

    private String gmtCreate;

    private String gmtUpdate;

    private String type;
}

