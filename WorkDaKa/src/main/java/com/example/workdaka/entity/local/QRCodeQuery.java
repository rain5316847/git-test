package com.example.workdaka.entity.local;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class QRCodeQuery {

    private String code;

    /*
     * 01:使；00:不是
     * */
    private String isBox;

    /*
    * 01:使；00:不是
    * */
    private String isCap;

    private String zone;

    /*仅适用于箱码信息查询，瓶码调用统一接口
    * 01:使用地区查询;00:不使用地区查询（即为只查询二维码）
    * */
    private String isZone;

}
