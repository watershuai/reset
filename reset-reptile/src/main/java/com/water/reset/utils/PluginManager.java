package com.water.reset.utils;

import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.plugin.BossRecruit;
import com.water.reset.crawler.plugin.LeJIaCrawler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class PluginManager {
    private static final ConcurrentHashMap<String, Class<CrawlerJob>> loadedSites = new ConcurrentHashMap<>();
    static {
        setPlugin();
        showPlugin();
    }

    public static void setPlugin(){
        Class<?> boss= BossRecruit.class;
        Class<?> lejia= LeJIaCrawler.class;
        loadedSites.put("boss",(Class<CrawlerJob>)boss);
        loadedSites.put("lejia",(Class<CrawlerJob>)lejia);
    }

    public static CrawlerJob getPlugin(String site){
        if (StringUtils.isEmpty(site)){
            return null;
        }
        Class<?> crawler=loadedSites.get(site);
        if (crawler == null) {
            return null;
        }
        CrawlerJob crawlerJob= null;
        try {
            crawlerJob = (CrawlerJob)crawler.newInstance();
        } catch (InstantiationException e) {
            log.error("{}获取插件异常：{}", site, e);
        } catch (IllegalAccessException e) {
            log.error("{}获取插件异常：{}", site, e);
        }
        return crawlerJob;
    }
    public static void showPlugin(){
        for (String key:loadedSites.keySet()){
            System.out.println("pluginKey:"+key+"------"+"pluginValue:"+loadedSites.get(key));
        }
    }
}
