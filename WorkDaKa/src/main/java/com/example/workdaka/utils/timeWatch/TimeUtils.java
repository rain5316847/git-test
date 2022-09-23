package com.example.workdaka.utils.timeWatch;

public class TimeUtils {

    /**
     * @return 当前毫秒数
     */
    public static long nowMs() {
        return System.currentTimeMillis();
    }

    /**
     * 当前毫秒与起始毫秒差
     *
     * @param millis
     * @param startMillis 开始纳秒数
     * @return 时间差
     */
    public static long diffMs(long millis, long startMillis) {
        return diffMs(startMillis, nowMs());
    }

}
