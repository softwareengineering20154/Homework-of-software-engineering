package com.active.school.biz.impl;

import com.active.school.biz.IGoodsBiz;
import com.active.school.dao.IGoodsDao;
import com.active.school.dao.impl.GoodsDaoImpl;
import com.active.school.po.Goods;

public class GoodsBizImpl implements IGoodsBiz {

	private IGoodsDao goodsDao;
	public GoodsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
	
		this.goodsDao = new GoodsDaoImpl();
	}
	@Override
	public boolean selectGoodsbyName(String fname) {
		// TODO Auto-generated method stub
		return goodsDao.selectByFname(fname) == null?false:true;
	}

	@Override
	public boolean insertNewGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.insert(goods)>0?true:false;
	}

}
