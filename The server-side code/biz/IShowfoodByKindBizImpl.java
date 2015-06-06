package com.active.school.biz;

import java.util.List;

import com.active.cate.po.Goods;

public interface IShowgoodsByKindBizImpl {
	
	public abstract List<Food> ShowfoodByKind(final int kind);

}
