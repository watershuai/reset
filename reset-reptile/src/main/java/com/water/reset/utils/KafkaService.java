package com.water.reset.utils;

import com.alibaba.fastjson.JSON;
import com.water.reset.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Slf4j
@Component
public class KafkaService {
    @Value("${kafka-topic.reptile-pages}")
    private String topic;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(Message message){
        try {
            ListenableFuture<SendResult<String,String>> future=kafkaTemplate.send(topic, JSON.toJSONString(message));
            future.addCallback(new ListenableFutureCallback<SendResult<String,String>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    log.info("kafka发送消息失败:" + message.getToken(),throwable.getMessage());
                }
                @Override
                public void onSuccess(SendResult<String, String> sendResult) {
                    log.info("kafka消息发送成功:" + message.getToken());
                }
            });
        }catch (Exception e){
            log.info("kafka发送消息异常:" + message.getToken(),e);
        }
    }
}
