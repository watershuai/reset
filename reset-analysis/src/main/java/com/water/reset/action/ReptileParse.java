package com.water.reset.action;

import com.water.reset.dto.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Controller
@Slf4j
public class ReptileParse {
    @KafkaListener(groupId = "reptile",topics = "reptile-pages")
    public ResultInfo crawlerParse(String message){
        log.info("消费者收到消息:" + message );

        return null;
    }
}
