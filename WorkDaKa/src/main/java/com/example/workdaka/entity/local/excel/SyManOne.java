package com.example.workdaka.entity.local.excel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sy_man_one")
public class SyManOne {

    private String Id;

    private String Name;

}
