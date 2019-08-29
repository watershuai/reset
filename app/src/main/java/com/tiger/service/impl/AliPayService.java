package com.tiger.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.yz.common.pay.service.IPay;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AliPayService implements IPay {
    public static final String CHARSET = "utf-8";
    public static final String FORMAT = "JSON";
    @Value("${alipay.signType}")
    private String SIGN_TYPE;
    @Value("${alipay.appId}")
    private String APP_ID;
    @Value("${alipay.publicKey}")
    private String ALIPAY_PUBLIC_KEY;
    @Value("${alipay.app.privateKey}")
    private String APP_PRIVATE_KEY;
    @Value("${server.hostName}")
    private String serverHostName;

    public <T> Object createOrder(T t) {
        String form = "";
        if ((t instanceof AliPayService.CreateOrderParam)) {
            AliPayService.CreateOrderParam createOrderParam = (AliPayService.CreateOrderParam) t;
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", this.APP_ID, this.APP_PRIVATE_KEY, "JSON", "utf-8", this.ALIPAY_PUBLIC_KEY, this.SIGN_TYPE);
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            alipayRequest.setNotifyUrl(createOrderParam.getNotifyUrl());
            alipayRequest.setReturnUrl(createOrderParam.getReturnUrl());
            Map<String, Object> bizContent = new HashMap();
            bizContent.put("out_trade_no", createOrderParam.getOutTradeNo());
            bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
            bizContent.put("total_amount", Double.valueOf(createOrderParam.getTotalAmount()));
            bizContent.put("subject", createOrderParam.getSubject());
            bizContent.put("passback_params", createOrderParam.getPassbackParams());
            alipayRequest.setBizContent(JSON.toJSONString(bizContent));
            try {
                form = (alipayClient.pageExecute(alipayRequest)).getBody();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return form;
    }

    public <T> Object refund(T t) throws Exception {
        return null;
    }

    public <T> Object createPayParams(T t) {
        return null;
    }

    public Object queryOrderStatus(String orderId) {
        return null;
    }
}
