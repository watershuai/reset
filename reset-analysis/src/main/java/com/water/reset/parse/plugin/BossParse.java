package com.water.reset.parse.plugin;

import com.alibaba.fastjson.JSONObject;
import com.water.reset.dto.BossJob;
import com.water.reset.dto.Message;
import com.water.reset.util.DataUtil;
import com.water.reset.util.Tool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Slf4j
public class BossParse {
   public String parse(String message){
       List<BossJob> result=new ArrayList<>();
       JSONObject object= Tool.getJSONObject(message);


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
           String companyType = e.select("div > div.info-company > div > p").text();
           job.setCompanyType(companyType);
           //要求
           String yaoqiu = e.select("div > div.info-primary > p").text();
           job.setCompanyPerson(yaoqiu);

           //谁招聘
           String who = e.select("div > div.info-publis > h3").text();
           job.setWho(who);
           //链接
           String href = e.select("div > div.info-primary > h3 > a").attr("href");
           job.setDetailUrl(href);
           //更新时间
          // String createTime = e.select("div > div.info-publis > p").text();
           job.setCreatTime(DataUtil.getCurrentTime());
           job.setCrawlerTime(object.getString("sendTime"));

           //获取工作列表数据
           Document document=Jsoup.parse(crawlerMessage);
           Elements job_primary = document.select("div[class='job-primary']");
           //遍历取出每一条工作数据记录集合
           List<String> mJobInfoList = job_primary.eachText();

           for (String jobInfo : mJobInfoList) {
               //可以根据空格做切割处理获取相关数据（注意：这里可以更精确的筛选对应标签取出对应值，我偷懒了）
               String[] mSplit = jobInfo.split(" ");
              // JobInfo mJobInfo = new JobInfo(mSplit[0], mSplit[1], mSplit[2], mSplit[3], mSplit[4], mSplit[5], mSplit[6], mSplit[7]);
           }



           result.add(job);
       }

       return null;
   }
}
