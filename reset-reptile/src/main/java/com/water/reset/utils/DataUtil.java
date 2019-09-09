package com.water.reset.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @author:water
 * @Data:2019/07/18
 */
public class DataUtil {
    /**
     * @param
     * @author:water
     * @Data 2019/07/22
     * @Description 获取当前时间
     */
    public static String getCurrentTime(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return format.format(new Date());
    }
}
