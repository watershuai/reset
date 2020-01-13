package com.water.reset.task;

import com.water.reset.domain.GoodsView;
import com.water.reset.redis.RedisUtils;
import com.water.reset.service.GoodsViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Slf4j
public class goodsViewTask {
    @Resource
    private RedisUtils redisUtils;
    @Resource
    GoodsViewService goodsViewService;

    // 每天凌晨一点执行
    @Scheduled(cron = "0 0 1 * * ? ")
    @Transactional(rollbackFor=Exception.class)
    public void createHyperLog() {
        log.info("浏览量入库开始");

        List<Long> list = goodsViewService.getAllGoodsId();
        list.forEach(articleId ->{
            // 获取每一篇文章在redis中的浏览量，存入到数据库中
            String key  = "articleId_"+articleId;
            Long view = redisUtils.countSetSize(key);
            if(view>0){
                GoodsView goodsView = goodsViewService.getById(articleId);
                Long views = view + goodsView.getViews();
                goodsView.setViews(views);
                int num = goodsViewService.updateGoodsById(goodsView);
                if (num != 0) {
                    log.info("数据库更新后的浏览量为：{}", views);
                    redisUtils.deleteKey(key);
                }
            }
        });
        log.info("浏览量入库结束");
    }
}
