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
        getHttpHelp().getHttpUtil().updateHeader("Cookie","lastCity=101020100; sid=sem_pz_bdpc_dasou_title; __c=1579509805; __g=sem_pz_bdpc_dasou_title; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1577772216,1579509805; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1579509805; __l=l=https%3A%2F%2Fsp0.baidu.com%2F9q9JcDHa2gU2pMbgoY3K%2Fadrc.php%3Ft%3D06KL00c00fDIFkY0Nnqh0KZEgsDMpaNX00000rFKmNC00000xDl8Xf.THdBULP1doZA8QMu1x60UWYsnW0sn1n4n7tzPNqCmyqxTAT0T1d9mW7hPyu9rj0snAFWmvw-0ZRqrDRYwbF7PjKKfWNKfWckwWfdnjT4n1wafYckrHR1PWn0mHdL5iuVmv-b5Hn1Pj0LPWmLrj0hTZFEuA-b5HDvFMwV5HDhmWYk0ARqpZwYTZnlQzqLILT8Xh9GTA-8QhPEUitOTv-b5gP-UNqsX-qBuZKWgvw9TvqdgLwGIAk-0APzm1YznjTsrf%26tpl%3Dtpl_11534_21264_17382%26l%3D1516323298%26attach%3Dlocation%253D%2526linkName%253D%2525E6%2525A0%252587%2525E5%252587%252586%2525E5%2525A4%2525B4%2525E9%252583%2525A8-%2525E6%2525A0%252587%2525E9%2525A2%252598-%2525E4%2525B8%2525BB%2525E6%2525A0%252587%2525E9%2525A2%252598%2526linkText%253DBOSS%2525E7%25259B%2525B4%2525E8%252581%252598%2525E2%252580%252594%2525E2%252580%252594%2525E6%252589%2525BE%2525E5%2525B7%2525A5%2525E4%2525BD%25259C%2525EF%2525BC%25258C%2525E6%252588%252591%2525E8%2525A6%252581%2525E8%2525B7%25259F%2525E8%252580%252581%2525E6%25259D%2525BF%2525E8%2525B0%252588%2525EF%2525BC%252581%2526xp%253Did(%252522m3340766780_canvas%252522)%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FH2%25255B1%25255D%25252FA%25255B1%25255D%2526linkType%253D%2526checksum%253D100%26ie%3Dutf-8%26f%3D8%26tn%3D02003390_25_hao_pg%26wd%3Dboss%25E7%259B%25B4%25E8%2581%2598%25E5%25AE%2598%25E7%25BD%2591%26oq%3Dboss%25E7%259B%25B4%25E8%2581%2598%25E5%25AE%2598%25E7%25BD%2591%26rqlang%3Dcn&r=https%3A%2F%2Fsp0.baidu.com%2F9q9JcDHa2gU2pMbgoY3K%2Fadrc.php%3Ft%3D06KL00c00fDIFkY0Nnqh0KZEgsDMpaNX00000rFKmNC00000xDl8Xf.THdBULP1doZA8QMu1x60UWYsnW0sn1n4n7tzPNqCmyqxTAT0T1d9mW7hPyu9rj0snAFWmvw-0ZRqrDRYwbF7PjKKfWNKfWckwWfdnjT4n1wafYckrHR1PWn0mHdL5iuVmv-b5Hn1Pj0LPWmLrj0hTZFEuA-b5HDvFMwV5HDhmWYk0ARqpZwYTZnlQzqLILT8Xh9GTA-8QhPEUitOTv-b5gP-UNqsX-qBuZKWgvw9TvqdgLwGIAk-0APzm1YznjTsrf%26tpl%3Dtpl_11534_21264_17382%26l%3D1516323298%26attach%3Dlocation%253D%2526linkName%253D%2525E6%2525A0%252587%2525E5%252587%252586%2525E5%2525A4%2525B4%2525E9%252583%2525A8-%2525E6%2525A0%252587%2525E9%2525A2%252598-%2525E4%2525B8%2525BB%2525E6%2525A0%252587%2525E9%2525A2%252598%2526linkText%253DBOSS%2525E7%25259B%2525B4%2525E8%252581%252598%2525E2%252580%252594%2525E2%252580%252594%2525E6%252589%2525BE%2525E5%2525B7%2525A5%2525E4%2525BD%25259C%2525EF%2525BC%25258C%2525E6%252588%252591%2525E8%2525A6%252581%2525E8%2525B7%25259F%2525E8%252580%252581%2525E6%25259D%2525BF%2525E8%2525B0%252588%2525EF%2525BC%252581%2526xp%253Did(%252522m3340766780_canvas%252522)%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FH2%25255B1%25255D%25252FA%25255B1%25255D%2526linkType%253D%2526checksum%253D100%26ie%3Dutf-8%26f%3D8%26tn%3D02003390_25_hao_pg%26wd%3Dboss%25E7%259B%25B4%25E8%2581%2598%25E5%25AE%2598%25E7%25BD%2591%26oq%3Dboss%25E7%259B%25B4%25E8%2581%2598%25E5%25AE%2598%25E7%25BD%2591%26rqlang%3Dcn&g=%2Fwww.zhipin.com%2Fshanghai%2F%3Fsid%3Dsem_pz_bdpc_dasou_title&friend_source=0&friend_source=0; __a=14521522.1577772215.1577772215.1579509805.4.2.2.2; __zp_stoken__=5618CdGmWiKrH1W8ycfpm32Aw%2F0Ri40AxSM6mmchnHor1nzmfKgc5kXmul7qQYK5OGn4Bsc9PJQDltm8H3mWxuhyUDWAmDAypgtTaCYogH7Q2HsbjKUaswUlc1WCoGohqxGw; __zp_sseed__=zW2DiLqjTmyIoxWb13Rssvz5E33G0XOoQX33aMJpe0U=; __zp_sname__=3ecb8a8c; __zp_sts__=1579509807561");
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
