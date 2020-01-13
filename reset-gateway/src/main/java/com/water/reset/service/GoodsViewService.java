package com.water.reset.service;

import com.water.reset.domain.GoodsView;

import java.util.List;

public interface GoodsViewService {
    /**
     * 获取某篇文章
     * @param id
     * @return
     */
    GoodsView getById(Long id);

    /**
     * 获取全部文章的id
     * @return
     */
    List<Long> getAllGoodsId();


    /**
     * 更新某篇文章的浏览量
     * @param goodsView
     * @return
     */
    int updateGoodsById(GoodsView goodsView);
}
