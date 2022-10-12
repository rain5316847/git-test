package com.example.workdaka.utils.Common;

import com.example.workdaka.utils.timeWatch.TraceWatchUtils;
import org.springframework.util.StopWatch;

import java.util.List;
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
