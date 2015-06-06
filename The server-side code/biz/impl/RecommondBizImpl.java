package com.active.school.biz.impl;

import com.active.school.biz.IRecmmondBiz;
import com.active.school.dao.IFoodDao;
import com.active.school.dao.impl.FoodDaoImpl;
import com.active.school.po.Food;

public class RecommondBizImpl implements IRecmmondBiz {

	private IFoodDao foodDao;
	public RecommondBizImpl() {
		// TODO Auto-generated constructor stubs
		super();
		this.foodDao = new FoodDaoImpl ();
	}
	@Override
	public int[] countAll() {
		// TODO Auto-generated method stub
		return foodDao.countAll();
	}

	@Override
	public Food getFood(int id) {
		// TODO Auto-generated method stub
		return foodDao.selectById(id);
	}

}
