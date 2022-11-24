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
@TableName("day_problem")
public class DayProblem {

    private String Id;

    private String ProblemName;

}
