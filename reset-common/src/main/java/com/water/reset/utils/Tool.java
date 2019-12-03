package com.water.reset.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
     * @param parms
     * @author:water
     * @Data 2019/07/18
     * @Deript http请求参数转化
     */
    public static String formatParams(List<NameValuePair> parms) {
        try {
            if (CollectionUtils.isNotEmpty(parms)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < parms.size(); i++) {
                    stringBuffer.append(parms.get(i).getName() + "=" + parms.get(i).getValue());
                    stringBuffer.append("&");
                }
                if (stringBuffer.toString().endsWith("&")) {
                    return stringBuffer.toString().substring(0, stringBuffer.toString().length() - 1);
                } else {
                    return stringBuffer.toString();
                }
            }
        } catch (Exception e) {
        }
        return "";
    }
    /**
     * @author:water
     * @Data 2019/07/22
     * @Description 根据时间生成唯一id
     */
    public static String getId(int num){
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return format.format(new Date())+getRandom(num);
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
