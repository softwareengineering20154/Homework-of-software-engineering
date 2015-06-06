package com.active.school.biz.impl;

import java.util.List;

import com.active.school.biz.IShowExpBiz;
import com.active.school.dao.IExpDao;
import com.active.school.dao.impl.ExpDaoImpl;
import com.active.school.vo.Showthoughts;

public class ShowExpBizImpl implements IShowExpBiz {
	
	private IExpDao expDao;
	

	public ShowExpBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.expDao = new ExpDaoImpl();
	}


	@Override
	public List<Showthoughts> showAllExp() {
		// TODO Auto-generated method stub
		return this.expDao.selectAll();
	}

}
