package com.water.reset.crawler.http;

import com.water.reset.enums.HttpMethod;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public class HttpHelp {
    public HttpClient httpClient;
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient= HttpClients.createDefault();
        HttpGet httpget=new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response=httpclient.execute(httpget);
        HttpEntity entity=response.getEntity();
        System.out.println(entity);
        String page= EntityUtils.toString(entity, "utf-8");
        System.out.println(page);
        response.close();
        httpclient.close();
    }

    /**
     * @param url 请求URL
     * @param param 请求参数
     * @param httpMethod http请求类型
     * @author:water
     * @Data 2019/07/26
     */
    private HttpResponse execute(String url, String param, HttpMethod httpMethod, String reqEncoding){
       HttpResponse httpResponse=null;
       Object response=getRequestMethod(url,httpMethod);
        RequestConfig requestConfig = RequestConfig.custom()
                //.setProxy(new HttpHost)
                //.setConnectTimeout(config.getConnectTimeout())
               // .setSocketTimeout(config.getResponseTimeout())
               // .setConnectionRequestTimeout(config.getConnectionRequestTimeout())
                //.setRedirectsEnabled(config.getAutoRedirect())
               // .setCircularRedirectsAllowed(config.getCircularRedirectsAllowed())
                .build();
        try {


        if (response instanceof HttpEntityEnclosingRequestBase) {
            HttpEntityEnclosingRequestBase httpRequestBase = (HttpEntityEnclosingRequestBase) response;
            //httpRequestBase.setProtocolVersion(this.config.getHttpVersion());
            //httpRequestBase.setHeaders(this.config.getHeadersCopy());
            httpRequestBase.setConfig(requestConfig);
            Header contentTypeHeader = httpRequestBase.getFirstHeader("Content-Type");
            /*if (contentTypeHeader != null) {
                entity.setContentType(contentTypeHeader);
            }*/
            StringEntity stringEntity = new StringEntity(param == null ? "" : param, getCharset(reqEncoding));
            httpRequestBase.setEntity(stringEntity);
            httpResponse = httpClient.execute(httpRequestBase);
        } else {
            HttpRequestBase httpRequestBase = (HttpRequestBase) response;
            //httpRequestBase.setProtocolVersion(this.config.getHttpVersion());
            //httpRequestBase.setHeaders(this.config.getHeadersCopy());
            httpRequestBase.setConfig(requestConfig);
            httpResponse = httpClient.execute(httpRequestBase);
        }
        }catch (Exception e){

        }
       return httpResponse;
    }
    private static HttpRequestBase getRequestMethod(String url, HttpMethod method) {
        HttpEntityEnclosingRequestBase enclosingRequestBase = null;
        HttpRequestBase requestBase = null;
        switch (method) {
            case GET:
                requestBase = new HttpGet(url);
                break;
            case POST:
                enclosingRequestBase = new HttpPost(url);
                break;
            default:
                throw new IllegalArgumentException("没有请求方法");
        }
        return StringUtils.isEmpty(requestBase) ? enclosingRequestBase : requestBase;
    }
    /**
     * post请求参数转换
     *
     * @param paramMap
     * @return
     */
    private static List<BasicNameValuePair> mapCovertBasicNameValuePair(Map<String, String> paramMap) {
        ArrayList<BasicNameValuePair> basicNameValuePairs = new ArrayList<>();
        if (paramMap == null) {
            return basicNameValuePairs;

        }
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            basicNameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return basicNameValuePairs;
    }
    //获取编码方式
    private static Charset getCharset(String name) {
        if (StringUtils.isEmpty(name)) {
            return Charset.forName("utf-8");
        } else {
            name = name.trim();
            return Charset.forName(Charset.isSupported(name) ? name : "utf-8");
        }
    }
}
