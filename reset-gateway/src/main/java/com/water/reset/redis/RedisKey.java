package com.water.reset.redis;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public class RedisKey {
    private static final String  PROJECT_NAME="reset-gateway";

    public static String key(String str){
        return PROJECT_NAME+":"+str;
    }
}
