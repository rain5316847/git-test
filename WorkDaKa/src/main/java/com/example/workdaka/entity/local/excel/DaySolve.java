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
@TableName("day_solve")
public class DaySolve {

    private String Id;

    private String SolveName;

}
