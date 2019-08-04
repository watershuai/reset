package com.water.reset.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;

import java.util.List;

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
}
