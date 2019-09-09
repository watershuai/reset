package com.water.reset.crawler.plugin;

import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.http.HttpHelp;
import com.water.reset.redis.RedisConfiguration;
import com.water.reset.utils.KafkaService;
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
    @Autowired
    private KafkaService kafkaService;
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
        getHttpHelp().getHttpUtil().updateHeader("Cookie","lastCity=101020100; _uab_collina=156566607104807943812901; __c=1567758979; __g=-; __zp_stoken__=8f897gRlHao3odvt1Ot1g81MTj%2BoYrjNyAmSEUt6%2Fy%2BXRF%2B04%2FGWuMpIKckGJS97MyZYvV151Mf3t3x18hMetz8f6w%3D%3D; __l=l=%2Fwww.zhipin.com%2Fweb%2Fcommon%2Fsecurity-check.html%3Fseed%3DvSNlrJ%252FfQr3LCYmkw3PFX73XiEOXuDK%252FxgvJn5GlFWc%253D%26name%3Ddff51ada%26ts%3D1567758979200%26callbackUrl%3D%252Fc101020100-p100101%252F&r=&friend_source=0&friend_source=0; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1565666070,1565683939,1567758993; __a=85690680.1565666070.1565666070.1567758979.20.2.4.20; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1567759042\n");
        String url="https://www.zhipin.com/c101020100-p100101/";
        String pageInfo=getHttpHelp().sendGet(url);
        if (!StringUtils.contains(pageInfo,"上海Java招聘")){
            log.info("获取第一页失败");
            return;
        }
        kafkaParse(pageInfo);
        for (int i=2;i<100;i++){
           url="https://www.zhipin.com/c101020100-p100101/?page="+i+"&ka=page-"+i+"";
           pageInfo=getHttpHelp().sendGet(url);
           kafkaParse(pageInfo);
        }
    }
}
