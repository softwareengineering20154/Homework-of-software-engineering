package com.active.school.biz.impl;

import com.active.school.biz.IExpBiz;
import com.active.school.dao.IExpDao;
import com.active.school.dao.impl.ExpDaoImpl;
import com.active.school.po.Exp;

public class ExpBizImpl implements IExpBiz {

	private IExpDao expDao;
	
	public ExpBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.expDao = new ExpDaoImpl();
	}

	@Override
	public boolean addExp(Exp exp) {
		// TODO Auto-generated method stub
		return this.expDao.insert(exp)>0?true:false;
	}


}
