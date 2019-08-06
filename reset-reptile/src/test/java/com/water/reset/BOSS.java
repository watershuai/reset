package com.water.reset;

import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.plugin.BossRecruit;
import org.junit.Test;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public class BOSS {
    CrawlerJob crawlerJob=new BossRecruit();

    @Test
    public void doTest(){
      crawlerJob.grasp();
    }

}
