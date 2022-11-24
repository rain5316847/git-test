package com.example.workdaka.entity.local.excel;

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
@TableName("day_ow")
public class DayOW {

    private String Id;

    private String Date;

    private String StartTime;

    private String Zone;

    private String Man;

    private String JlMan;

    private String ClMan;

    private String EndTime;

    private String OrderNo;

    private String Code;

    private String Name;

    private String Type;

    private String Problem;

    private String Solve;

    private String State;

    private String Epc;

    private String isFac;

}
