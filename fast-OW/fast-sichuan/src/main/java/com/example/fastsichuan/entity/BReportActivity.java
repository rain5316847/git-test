package com.example.fastsichuan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("b_report_activity")
public class BReportActivity {

    private String id;

    private String activityName;

    private String dec;

    private String status;

    private String gmtCreate;

    private String gmtUpdate;
}
