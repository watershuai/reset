package com.water.reset.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tool {
    /**
     * @param millisecond 休眠时间 毫秒
     * @author:water
     * @Data 2019/07/18
     */
    public static void sleep(int millisecond){
        if (millisecond < 1){
            return;
        }
        try {
            Thread.sleep(millisecond);
        }catch (InterruptedException e){
            log.error("线程休眠异常:",e);
        }
    }
}
