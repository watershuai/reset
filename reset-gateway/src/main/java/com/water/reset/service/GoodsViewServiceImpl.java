package com.water.reset.service;

import com.water.reset.domain.GoodsView;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsViewServiceImpl implements GoodsViewService {
    @Override
    public GoodsView getById(Long id) {
        return null;
    }

    @Override
    public List<Long> getAllGoodsId() {
        return null;
    }

    @Override
    public int updateGoodsById(GoodsView goodsView) {
        return 0;
    }
}
