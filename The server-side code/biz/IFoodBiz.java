package com.active.school.biz;

import com.active.school.po.Goods;

public interface IGoodsBiz {
	public abstract boolean selectGoodsbyName(final String fname); 
	public abstract boolean insertNewGoods(final Goods goods);

}
