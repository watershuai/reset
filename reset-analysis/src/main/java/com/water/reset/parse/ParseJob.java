package com.water.reset.parse;

import com.alibaba.fastjson.JSONObject;
import com.water.reset.util.RedisKey;
import com.water.reset.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public  abstract class ParseJob {
    @Autowired
    private RedisUtils redisUtils;
    /**
     * 具体实现重写入口
     **/
    public abstract void parse(JSONObject message);

    /**
     * 数据存储，先存数据库再存缓存
     **/
    public void save(String key,String value,int type){
        redisUtils.insertObject(RedisKey.key("Boss-"+key+""),value,-1L);
    }
}
