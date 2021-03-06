package com.water.reset.crawler.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.water.reset.dto.HttpInfo;
import com.water.reset.enums.HttpMethod;
import com.water.reset.service.IHttpCheck;
import com.water.reset.utils.HttpUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.cookie.Cookie;
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
@Slf4j
public class HttpHelp {
    @Getter
    protected HttpUtil httpUtil;
    @Getter
    protected HttpClient httpClient;
    public CookieStore cookieStore = new BasicCookieStore();

    @Getter
    @Setter
    private IHttpCheck iHttpCheck;

    public HttpHelp() {
        httpUtil = new HttpUtil();
    }

    @Getter
    protected HttpHost httpHost;

    public final HttpHost setProxy(String ip,int host,String scheme) {
        //httpHost = StringUtils.isEmpty(ip) ? null : HttpHost.create(ip);
        httpHost=new HttpHost(ip,host,scheme);
        return httpHost;
    }

    /**
     * 添加cookie对象
     */
    public final void addCookie(Cookie cookie) {
        this.cookieStore.addCookie(cookie);
    }

    /**
     * 清空当前CookieStore
     */
    public final void clearCookieStore() {
        this.cookieStore.clear();
    }

    /**
     * 获取当前CookieStore中的Cookie集合
     */
    public final List<Cookie> getCookies() {
        return this.cookieStore.getCookies();
    }

    /**
     * 获取CookieStore的字符串形式（key1=value1,key2=value2...）
     */
    public final String getCookieStoreString() {
        StringBuilder cookieStr = new StringBuilder();
        List<Cookie> cookies = getCookies();
        for (Cookie cookie : cookies) {
            cookieStr.append(cookie.getName())
                    .append("=")
                    .append(cookie.getValue())
                    .append(";");
        }
        return cookieStr.length() < 1 ? "" : cookieStr.substring(0, cookieStr.length() - 1);
    }

    /**
     * @param url 请求地址
     * @author:water
     * @Data 2019/07/18
     * GET请求
     */
    public String sendGet(String url) {
        return sendGet(url, "");
    }

    /**
     * @param url 请求地址
     * @author:water
     * @Data 2019/07/18
     */
    public String sendGet(String url, String reqEncoding) {
        return requestProcessing(url, "", HttpMethod.GET, reqEncoding);
    }

    /**
     * @param url 请求地址
     * @author:water
     * @Data 2019/07/18
     * POST请求
     */
    public String sendPost(String url) {
        return sendPost(url, "");
    }

    public String sendPost(String url, String param) {
        return sendPost(url, param, "");
    }

    public String sendPost(String url, String param, String reqEncoding) {
        return requestProcessing(url, param, HttpMethod.POST, "");
    }

    /**
     * @param url 请求地址
     * @author:water
     * @Data 2019/07/18
     * 请求后对请求的处理
     */
    private String requestProcessing(String url, String param, HttpMethod httpMethod, String reqEncoding) {
        String resultString = "";
        for (int i = 1; i <= 3; i++) {
            HttpInfo httpInfo = execute(url, param, httpMethod, reqEncoding);
            resultString = httpInfo.getResultString();
            if (iHttpCheck != null) {
                resultString = iHttpCheck.advanceResult(resultString);
            }
            if (iHttpCheck != null) {
                if (!iHttpCheck.resultRetry(resultString)) {
                    break;
                }
            } else {
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
    private HttpInfo execute(String url, String param, HttpMethod httpMethod, String reqEncoding) {
        cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpResponse httpResponse = null;
        HttpInfo httpInfo = new HttpInfo();
        //请求头
        try {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setProxy(this.getHttpHost())
                    .build();
            if (httpMethod.equals(HttpMethod.POST)) {
                HttpPost httpPost = new HttpPost(url);
                StringEntity stringEntity = new StringEntity(param == null ? "" : param, getCharset(reqEncoding));
                Header contentTypeHeader = httpPost.getFirstHeader("Content-Type");
                if (contentTypeHeader != null) {
                    stringEntity.setContentType(contentTypeHeader);
                }
                httpPost.setConfig(requestConfig);
                httpPost.setEntity(stringEntity);
                httpPost.setHeaders(httpUtil.listHeadersToAll());
                httpPost.setProtocolVersion(HttpVersion.HTTP_1_1);
                httpResponse = httpClient.execute(httpPost);

            } else if (httpMethod.equals(HttpMethod.GET)) {
                HttpGet httpGet = new HttpGet(url);
                httpGet.setConfig(requestConfig);
                httpGet.setHeaders(httpUtil.listHeadersToAll());
                httpGet.setProtocolVersion(HttpVersion.HTTP_1_1);
                httpResponse = httpClient.execute(httpGet);
            }
            HttpEntity httpEntity = httpResponse.getEntity();
            if (!StringUtils.isEmpty(httpEntity)) {
                //byte[] rspdata = EntityUtils.toByteArray(httpEntity);
                String entity = EntityUtils.toString(httpEntity, "GBK");
                if (!entity.contains("</body>")) {  //如果是json数据中文会出现unicode编码，解决此方法
                    JSONObject json = JSONObject.parseObject(entity);
                    httpInfo.setResultString(JSON.toJSONString(json));
                }else {
                    httpInfo.setResultString(entity);
                }
            }
            httpInfo.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        } catch (IOException e) {
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
