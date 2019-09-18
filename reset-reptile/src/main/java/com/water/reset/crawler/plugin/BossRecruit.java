package com.water.reset.crawler.plugin;

import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.http.HttpHelp;
import com.water.reset.redis.RedisConfiguration;
import com.water.reset.utils.KafkaService;
import com.water.reset.utils.Tool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Slf4j
public class BossRecruit extends CrawlerJob {
    @Override
    public void crawl() {
        try {
            getHttpHelp().getHttpUtil().updateHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
            String result = getHttpHelp().sendGet("https://www.zhipin.com/");
            if (StringUtils.isEmpty(result)){
                log.info("获取官网首页为空");
                return;
            }
            doCrawl();
        }catch (Exception e){
            log.info("boss爬取出现异常",e);
        }
    }
    private void doCrawl(){
        getHttpHelp().getHttpUtil().updateHeader("Referer","https://www.zhipin.com/c101020100-p100101/");
        getHttpHelp().getHttpUtil().updateHeader("Upgrade-Insecure-Requests","1");
        getHttpHelp().getHttpUtil().updateHeader("Cookie","lastCity=101020100; _uab_collina=156411725344202097440483; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1568598087,1568702770; __c=1568702770; __g=-; __l=l=%2Fwww.zhipin.com%2F&r=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DFU2Au6eTukC3NBVcaqjBnWKlXq0DsGyx72jh9pTRGC7MmDfUXVETaKaImUWdPt-a%26wd%3D%26eqid%3Dd365106c000822b3000000045d80812e&friend_source=0&friend_source=0; __a=7165061.1564117253.1568598087.1568702770.33.5.2.17; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1568702772; __zp_stoken__=498bkILO8ETJtzMrzHydBFwoHkmVo7wrhEHauy%2FanXyzOU9cbSbzjQxfRuJ50VCc%2BsCSDt1%2FTxTYn%2FnfTTdUrzvJHg%3D%3D");
        String url="https://www.zhipin.com/c101020100/?query=Java&industry=&position=&ka=hot-position-1";
        String pageInfo=getHttpHelp().sendGet(url);
        if (!StringUtils.contains(pageInfo,"上海Java招聘")){
            log.info("获取第一页失败");
            return;
        }
        kafkaParse(pageInfo);
        for (int i=2;i<50;i++){
           url="https://www.zhipin.com/c101020100/?query=Java&page="+i+"&ka=page-next";
           pageInfo=getHttpHelp().sendGet(url);
            if (!StringUtils.contains(pageInfo,"上海Java招聘")){
                log.info("采集中止");
                break;
            }
           kafkaParse(pageInfo);
           Tool.sleep(2000);
        }
    }
}
