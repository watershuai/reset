package com.water.reset.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;


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
    /**
     * @param json json数
     * @author:water
     * @Data 2019/09/06
     * @Description json数据转化
     */
    public static JSONObject getJSONObject(String json) {
        JSONObject jsonObject = null;

        try {
            if (StringUtils.isNotEmpty(json) && isJson(json)) {
                jsonObject = JSONObject.parseObject(json);
            }
        } catch (Exception e) {
            log.error("json数据转化失败", e);
        }

        return jsonObject;
    }
    /**
     * @param json json数
     * @author:water
     * @Data 2019/09/06
     * @Description 判断是否是json
     */
    public static boolean isJson(String json) {
        try {
            JSON.parse(json);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
