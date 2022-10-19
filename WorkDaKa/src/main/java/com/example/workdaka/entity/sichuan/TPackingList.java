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
@TableName("t_packing_list")
public class TPackingList {

    private String id;

    private String packingInfoId;

    private String code;

    private String insideCode;

    private String flag;

    private String orgId;

    private String gmtCreate;

    private String gmtUpdate;
}
