package com.water.reset.utils;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public final class HttpUtil {
   private final List<Header> headerList;
   @Getter
   @Setter
   private int connectTimeOut=30000;
    @Getter
    @Setter
   private int responseTimeout=30000;
    @Getter
    @Setter
   private int connectionRequestTimeout=30000;
    @Getter
    @Setter
   //是否重定向,默认true
   private Boolean redirectsEnabled=true;

   public HttpUtil(){
       headerList=new ArrayList<>();
    }

    /**
     * @param name 请求头的名字
     * @param value 请求头的值
     * @author:water
     * @Data 2019/07/18
     */
    public synchronized void updataHeader(String name,String value){
       Header header=getHeaderByName(name);
       if (null == header){
           headerList.add(new BasicHeader(name,value));
       }else {
           headerList.remove(name);
           headerList.add(new BasicHeader(name,value));
       }
    }
    /**
     * @param name 请求头文字
     * @author:water
     * @Data 2019/07/18
     */
    private Header getHeaderByName(String name) {
        for (Header header : headerList) {
            if (header.getName().equalsIgnoreCase(name)) {
                return header;
            }
        }
        return null;
    }
    /**
     * @author:water
     * @Data 2019/07/18
     * @return  将list头文件转成数组
     */
    public synchronized Header[] listHeadersToAll() {
        Header[] allHeader = new Header[headerList.size()];//转成所需要的类型
        return headerList.toArray(allHeader);
    }
}
