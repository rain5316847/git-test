package com.example.demodelet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("this_user")
public class ThisUser {

    private String id;

    private String name;

    private String pwd;

    private Date time;

    private String tel;

}