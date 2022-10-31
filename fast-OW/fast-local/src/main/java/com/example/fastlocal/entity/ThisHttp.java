package com.example.fastlocal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("this_http")
public class ThisHttp {

    @TableId(type = IdType.AUTO)
    private String id;

    private String requestUri;

    private String requestUrl;

    private String remoteAddr;

    private String queryString;

    private String remoteHost;

    private String remotePort;

    private String serveName;

    private String servePort;

}
