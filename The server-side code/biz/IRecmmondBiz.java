package com.active.school.biz;

import com.active.school.po.Goods;

public interface IRecmmondBiz {
	public abstract int[] countAll();
	public abstract Goods getGoods(final int id);

}
