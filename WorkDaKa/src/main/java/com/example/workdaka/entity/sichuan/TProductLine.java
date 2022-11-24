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
@TableName("t_product_line")
public class TProductLine {

    private String id;

    private String factoryId;

    private String no;

    private String name;

    private String remark;

    private String orgId;

    private String gmtCreate;

    private String gmtUpdate;

}
