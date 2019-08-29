package com.water.reset.crawler.plugin;

import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.http.HttpHelp;
import com.water.reset.redis.RedisConfiguration;
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
    protected void crawl() {
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
        getHttpHelp().getHttpUtil().updateHeader("Referer","https://www.zhipin.com/");
        getHttpHelp().getHttpUtil().updateHeader("Cookie",getHttpHelp().getCookieStoreString());
        String url="https://www.zhipin.com/c101020100-p100101/";
        String pageInfo=getHttpHelp().sendGet(url);

        url="https://www.zhipin.com/job_detail/?query=&city=101020100&industry=&position=100101";
        getHttpHelp().getHttpUtil().updateHeader("Referer","https://www.zhipin.com/c101020100-p100101/");
        getHttpHelp().getHttpUtil().updateHeader("Upgrade-Insecure-Requests","1");
        pageInfo=getHttpHelp().sendGet(url);
        if (!StringUtils.contains(pageInfo,"上海Java招聘")){
            log.info("获取第一页失败");
            return;
        }
        for (int i=2;i<100;i++){
           url="https://www.zhipin.com/c101020100-p100101/?page="+i+"&ka=page-"+i+"";
           pageInfo=getHttpHelp().sendGet(url);
        }
    }
}
