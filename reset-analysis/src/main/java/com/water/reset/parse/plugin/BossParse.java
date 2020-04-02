package com.water.reset.parse.plugin;

import com.alibaba.fastjson.JSONObject;
import com.water.reset.dto.BossJob;
import com.water.reset.parse.ParseJob;
import com.water.reset.util.DataUtil;
import com.water.reset.utils.Tool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Slf4j
public class BossParse extends ParseJob {
    @Override
    public void parse(JSONObject object){
       String crawlerMessage=object.getString("msg");
       Document parse = Jsoup.parse(crawlerMessage);

       List<Element> elements= parse.select("#main > div > div.job-list > ul > li");
       for(Element e:elements){
           BossJob job=new BossJob();

           //职位名
           String jobName = e.select("div.info-primary > h3 > a > div.job-title").text();
           job.setJobName(jobName);

           //薪酬
           String salary = e.select("div > div.info-primary > h3 > a > span").text();
           job.setMoney(salary);
           //公司名
           String companyName = e.select("div > div.info-company > div > h3 > a").text();
           job.setCompanyName(companyName);


           //公司类型
           String res="";
           String yaoqiu="";
           try {
               res= e.select("div > div.info-company > div > p").html();
               String[] ss = res.split("<em class=\"vline\"></em>");
               int count=1;
               for (String string : ss) {
                   if (count == 1){
                       job.setCompanyType(string);
                   }
                   if (count == 2){
                       if (StringUtils.contains(string,"人")){
                           job.setCompanyPerson(string);
                       }else {
                           job.setFinancing(string);
                       }
                   }
                   if (count == 3){
                       job.setCompanyPerson(string);
                   }
                   count++;
               }
               //要求
               yaoqiu= e.select("div > div.info-primary > p").html();
               String[] s2=yaoqiu.split("<em class=\"vline\"></em>");

               int count2=1;
               for (String string : s2) {
                   if (count2 == 1){
                       job.setCompanyAdress(string);
                   }
                   if (count2 == 2){
                       if (StringUtils.contains(string,"年") || StringUtils.contains(string,"不限")){
                           job.setJobTime(string);
                       }else {
                           job.setEducation(string);
                       }
                   }
                   if (count2 == 3){
                       job.setEducation(string);
                   }
                   count2++;
               }
           }catch (Exception e1){
               log.info("发生异常:目标值:"+res+"目标值2:"+yaoqiu,e1);
           }


           //谁招聘
           String who = e.select("div > div.info-publis > h3").text();
           job.setWho(who);
           Tool.sleep(1000);
           //链接
           String href = e.select("div > div.info-primary > h3 > a").attr("href");
           job.setDetailUrl(href);
           //更新时间
          // String createTime = e.select("div > div.info-publis > p").text();
           job.setCreatTime(DataUtil.getCurrentTime());
           job.setCrawlerTime(object.getString("sendTime"));
       }
   }



   public static void main(String[] args){
       String res="互联网<em class=\"vline\"></em>已上市<em class=\"vline\"></em>1000-9999人";
       String[] ss = res.split("<em class=\"vline\"></em>");
       for (String string : ss) {
           if(ss != null && !("".equals(string))) {
               System.out.println(string);
           }
       }
   }



}
