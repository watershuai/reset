package com.water.reset.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
    private static final String ACCEPT = "Accept";
    private static final String DEFAULT_ACCEPT_VALUE = "*/*";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CACHE_CONTROL = "Cache-Control";
    private static final String DEFAULT_CACHE_CONTROL_VALUE = "no-cache";
    private static final String PRAGMA = "Pragma";
    private static final String USERAGENT = "User-Agent";
    private static final String DEFAULT_USERAGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36";

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
        headerList.add(new BasicHeader(ACCEPT, DEFAULT_ACCEPT_VALUE));
        headerList.add(new BasicHeader(CONTENT_TYPE, "application/x-www-form-urlencoded"));//form表单
        headerList.add(new BasicHeader(USERAGENT, DEFAULT_USERAGENT_VALUE));//默认代理客户端头
        //禁止服务器使用缓存
        headerList.add(new BasicHeader(CACHE_CONTROL, DEFAULT_CACHE_CONTROL_VALUE));
        headerList.add(new BasicHeader(PRAGMA, DEFAULT_CACHE_CONTROL_VALUE));
        Header[] allHeader = new Header[headerList.size()];//转成所需要的类型
        return headerList.toArray(allHeader);
    }
}
