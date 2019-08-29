package com.water.reset.utils;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Slf4j
public class Tool {

    /**
     * @author:water
     * @Data 2019/07/22
     * @Description 生成唯一token
     */
    public static String getToken(){
        SimpleDateFormat format=new SimpleDateFormat("YYYYMMddHHmmssSSS");
        return format.format(new Date())+getRandom(3);
    }

    /**
     * @param num 随机数个数
     * @author:water
     * @Data 2019/07/22
     * @Description 获取随机数
     */
    public static String getRandom(int num){
        if (num < 1){
            return "";
        }
        StringBuilder builder=new StringBuilder();
        Random random=new Random();
        for (int i=0; i<num; i++){
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }
}
