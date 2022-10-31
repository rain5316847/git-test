package com.example.fastlocal.utils.common;

import java.util.Map;
import java.util.Set;

public class HashMapUtils {

    public static String showHashMap(Map<String, Object> map){
        if(map.isEmpty()){
            return null;
        }else {
            Set<Map.Entry<String, Object>> ms =map.entrySet();
            for (Map.Entry entry : ms) {
                return entry.getKey()+"="+entry.getValue();
            }
        }
        return null;
    }

}
