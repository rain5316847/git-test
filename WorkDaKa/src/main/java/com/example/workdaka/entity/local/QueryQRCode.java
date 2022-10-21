package com.example.workdaka.entity.local;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class QueryQRCode {

    /*
    * 产品解析内容
    * */
    String code;

    /*
    * 产品类型：1 箱码；2 瓶码；
    * */
    String product;

    /*
    * 查询类型：1：网址查询；2：解析内容查询；3：二维码查询;
    * */
    String type;

}
