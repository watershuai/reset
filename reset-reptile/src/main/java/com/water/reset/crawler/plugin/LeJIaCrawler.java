package com.water.reset.crawler.plugin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.water.reset.crawler.CrawlerJob;
import com.water.reset.utils.Tool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LeJIaCrawler extends CrawlerJob {
    @Override
    public void crawl() {
        try {
            getHttpHelp().getHttpUtil().updateHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
            String result=getHttpHelp().sendGet("https://www.lejiastore.com/mobile/");
            getHttpHelp().getHttpUtil().updateHeader("referer","https://www.lejiastore.com/mobile/index.php?m=category");
            getHttpHelp().getHttpUtil().updateHeader(":path","/mobile/category/index/childcategory/id/6.html");
            getHttpHelp().getHttpUtil().updateHeader("x-requested-with","XMLHttpRequest");
            result=getHttpHelp().sendGet("https://www.lejiastore.com/mobile/category/index/childcategory/id/6.html");
            if (StringUtils.isEmpty(result)){
                log.info("获取官网首页为空");
                return;
            }
            doCrawl();
        }catch (Exception e){
            log.info("乐佳爬取出现异常",e);
        }
    }


    private void doCrawl(){
        for (int i=0;i<=20 ;i++) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("page", "1"));
            list.add(new BasicNameValuePair("size", "10"));
            String parms= JSON.toJSONString(list);
            String url="https://www.lejiastore.com/mobile/category/35"+i+".html?display=grid&brand=&intro=&price_min=0&price_max=0&" +
               "filter_attr=&sort=goods_id&order=desc&keyword=&isself=0&hasgoods=0&promotion=0&region_id=0&area_id=1&ext=&cou_id=0";
            String result = getHttpHelp().sendPost(url,parms,"utf-8");
            JSONObject jsonObject=JSONObject.parseObject(result);
            String total=jsonObject.get("totalPage").toString();
            if (StringUtils.isNotEmpty(total)){
                Integer totalPage=Integer.parseInt(total);
                if (totalPage > 0){
                    kafkaParse(result);
                    for (int j=2; j<=totalPage;j++){
                        List<NameValuePair> list2 = new ArrayList<NameValuePair>();
                        list2.add(new BasicNameValuePair("page", String.valueOf(i)));
                        list2.add(new BasicNameValuePair("size", "10"));
                        parms= JSON.toJSONString(list);
                        result = getHttpHelp().sendPost(url,parms,"utf-8");
                        kafkaParse(result);
                        Tool.sleep(3000);
                    }
                }
            }else {
                log.info("乐佳爬取出现非正常,爬取终止，已爬取"+i+"页");
                break;
            }
            Tool.sleep(3000);
        }
    }
}
