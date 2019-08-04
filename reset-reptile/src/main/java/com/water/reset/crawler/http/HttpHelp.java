package com.water.reset.crawler.http;

import com.water.reset.dto.HttpInfo;
import com.water.reset.enums.HttpMethod;
import com.water.reset.service.IHttpCheck;
import com.water.reset.utils.HttpUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
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
    private static HttpUtil httpUtil=new HttpUtil();
    public static HttpClient httpClient;
    public static CookieStore cookieStore;
    @Getter
    @Setter
    private IHttpCheck iHttpCheck;
    public HttpHelp(){
        httpUtil=new HttpUtil();
    }

    public static void main(String[] args) throws IOException {
        // CloseableHttpClient httpclient= HttpClients.createDefault();
        // HttpGet httpget=new HttpGet("http://www.baidu.com");
        /*CloseableHttpResponse response=httpclient.execute(httpget);
        HttpEntity entity=response.getEntity();
        System.out.println(entity);
        String page= EntityUtils.toString(entity, "utf-8");
        System.out.println(page);
        response.close();
        httpclient.close();*/
        //execute("http://www.baidu.com", "", HttpMethod.GET, "");
    }

    /**
     * @param url 请求地址
     * @author:water
     * @Data 2019/07/18
     * GET请求
     */
    private String sendGet(String url) {
        return sendGet(url,"");
    }
    /**
     * @param url 请求地址
     * @author:water
     * @Data 2019/07/18
     */
    private String sendGet(String url,String reqEncoding) {
        return requestProcessing(url,"",HttpMethod.GET,reqEncoding);
    }

    /**
     * @param  url 请求地址
     * @author:water
     * @Data 2019/07/18
     * POST请求
     */
    private String sendPost(String url) {
        return sendPost(url,"");
    }
    private String sendPost(String url,String param){
        return sendPost(url,param,"");
    }
    private String sendPost(String url,String param,String reqEncoding ){
        return requestProcessing(url,param,HttpMethod.POST,"");
    }

    /**
     * @param url 请求地址
     * @author:water
     * @Data 2019/07/18
     * 请求后对请求的处理
     */
    public  String requestProcessing(String url,String param, HttpMethod httpMethod, String reqEncoding){
        String resultString="";
       for (int i=1 ;i<=3 ;i++){
           HttpInfo httpInfo=execute(url,param,httpMethod,reqEncoding);
           resultString=httpInfo.getResultString();
           if (iHttpCheck !=null){
               resultString=iHttpCheck.advanceResult(resultString);
           }
           if (iHttpCheck !=null) {
               if (!iHttpCheck.resultRetry(resultString)){
                   break;
               }
           }else {
               break;
           }
       }
       return resultString;
    }

    /**
     * @param url        请求URL
     * @param param      请求参数
     * @param httpMethod http请求类型
     * @author:water
     * @Data 2019/07/26
     */
    public  HttpInfo execute(String url, String param, HttpMethod httpMethod, String reqEncoding) {
        cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpResponse httpResponse = null;
        HttpInfo httpInfo=new HttpInfo();
        //请求头
        try {
            if (httpMethod.equals(HttpMethod.POST)) {
                HttpPost httpPost = new HttpPost(url);
                StringEntity stringEntity = new StringEntity(param == null ? "" : param, getCharset(reqEncoding));
                Header contentTypeHeader = httpPost.getFirstHeader("Content-Type");
                if (contentTypeHeader != null) {
                    stringEntity.setContentType(contentTypeHeader);
                }
                httpPost.setEntity(stringEntity);
                httpPost.setHeaders(httpUtil.listHeadersToAll());
                httpPost.setProtocolVersion(HttpVersion.HTTP_1_1);
                httpResponse = httpClient.execute(httpPost);

            } else if (httpMethod.equals(HttpMethod.GET)) {
                HttpGet httpGet = new HttpGet(url);
                httpGet.setHeaders(httpUtil.listHeadersToAll());
                httpGet.setProtocolVersion(HttpVersion.HTTP_1_1);
                httpResponse = httpClient.execute(httpGet);
            }
            HttpEntity httpEntity = httpResponse.getEntity();
            if (!StringUtils.isEmpty(httpEntity)) {
                byte[] rspdata = EntityUtils.toByteArray(httpEntity);
                httpInfo.setResultString(new String(rspdata, getCharset(reqEncoding)));
            }
            httpInfo.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        }
        catch (IOException e) {
        }
        return httpInfo;
    }
   /* private static HttpInfo execute(String url, String param, HttpMethod httpMethod, String reqEncoding) {
        HttpResponse httpResponse = null;
        HttpInfo httpInfo=new HttpInfo();
        Object response = getRequestMethod(url, httpMethod);
        RequestConfig requestConfig = RequestConfig.custom()
                //.setProxy(new HttpHost)
                *//*.setConnectTimeout(httpUtil.getConnectTimeOut())
                .setSocketTimeout(httpUtil.getResponseTimeout())
                .setConnectionRequestTimeout(httpUtil.getConnectionRequestTimeout())
                .setRedirectsEnabled(httpUtil.getRedirectsEnabled())*//*
                //.setCircularRedirectsAllowed(config.getCircularRedirectsAllowed())
                .build();
        try {
            if (response instanceof HttpEntityEnclosingRequestBase) {
                HttpEntityEnclosingRequestBase httpRequestBase = (HttpEntityEnclosingRequestBase) response;
                httpRequestBase.setProtocolVersion(HttpVersion.HTTP_1_1);
                //httpRequestBase.setHeaders(this.config.getHeadersCopy());
                httpRequestBase.setConfig(requestConfig);
                Header contentTypeHeader = httpRequestBase.getFirstHeader("Content-Type");
            *//*if (contentTypeHeader != null) {
                entity.setContentType(contentTypeHeader);
            }*//*
                StringEntity stringEntity = new StringEntity(param == null ? "" : param, getCharset(reqEncoding));
                httpRequestBase.setEntity(stringEntity);
                httpResponse = httpClient.execute(httpRequestBase);
            } else {
                HttpRequestBase httpRequestBase = (HttpRequestBase) response;
                httpRequestBase.setProtocolVersion(HttpVersion.HTTP_1_1);
                //httpRequestBase.setHeaders();
                httpRequestBase.setConfig(requestConfig);
                httpResponse = httpClient.execute(httpRequestBase);
            }

            HttpEntity entity = httpResponse.getEntity();
            if (!StringUtils.isEmpty(entity)) {
                byte[] stringData = EntityUtils.toByteArray(entity);
                String encoding=getResponseCharset(entity.getContentEncoding())
                httpInfo.setResultString(new String(stringData,));
            }
        } catch (Exception e) {

        }
        return httpResponse;
    }*/

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

    /**
     * map转Header数组
     *
     * @param headerMap
     * @return
     */
    private static List<Header> mapConvertHeader(Map<String, String> headerMap) {
        ArrayList<Header> headers = new ArrayList<>();
        if (headerMap == null) {
            return headers;
        }
        headers = new ArrayList<>();
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            headers.add(new BasicHeader(entry.getKey(), entry.getValue()));
        }
        return headers;
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

    public HttpUtil getHttpUtil() {
        return httpUtil;
    }

    public void setHttpUtil(HttpUtil httpUtil) {
        this.httpUtil = httpUtil;
    }


    public static String getResponseCharset(String contentType) {
        try {
            if (contentType == null) {
                return null;
            }
            if (contentType.toLowerCase().contains("charset")) {
                String[] items = contentType.split(";");
                for (String item : items) {
                    if (item != null && item.toLowerCase().contains("charset")) {
                        return item.split("=")[1];
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
