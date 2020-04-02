package com.water.reset.util;

import com.water.reset.parse.ParseJob;
import com.water.reset.parse.plugin.BossParse;
import com.water.reset.parse.plugin.LeJiaParse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class PluginManager {
    private static final ConcurrentHashMap<String, Class<ParseJob>> loadedSites = new ConcurrentHashMap<>();
    static {
        setPlugin();
        showPlugin();
    }

    public static void setPlugin(){
        Class<?> boss= BossParse.class;
        Class<?> lejia= LeJiaParse.class;
        loadedSites.put("boss",(Class<ParseJob>)boss);
        loadedSites.put("lejia",(Class<ParseJob>)lejia);
    }

    public static ParseJob getPlugin(String site){
        if (StringUtils.isEmpty(site)){
            return null;
        }
        Class<?> crawler=loadedSites.get(site);
        if (crawler == null) {
            return null;
        }
        ParseJob crawlerJob= null;
        try {
            crawlerJob = (ParseJob)crawler.newInstance();
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
