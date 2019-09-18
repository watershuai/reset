package com.water.reset.util;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public class RedisKey {
    private static final String  PROJECT_NAME="reset-parse";

    public static String key(String str){
        return PROJECT_NAME+":"+str;
    }
}
