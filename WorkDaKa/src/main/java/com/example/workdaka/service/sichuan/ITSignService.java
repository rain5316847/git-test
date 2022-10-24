package com.example.workdaka.service.sichuan;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.sichuan.TSign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ITSignService extends IService<TSign> {

    List<HashMap<String, Object>> getPackingSign(String QRCode);

}
