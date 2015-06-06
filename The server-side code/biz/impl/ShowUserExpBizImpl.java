package com.active.school.biz.impl;

import java.util.List;

import com.active.school.biz.IShowHisExpBiz;
import com.active.school.dao.IExpDao;
import com.active.school.dao.impl.ExpDaoImpl;
import com.active.school.po.Exp;
import com.active.school.vo.Showthoughts;

public class ShowHisExpBizImpl implements IShowHisExpBiz {

   private 	IExpDao expDao;
	
	
	public ShowHisExpBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.expDao = new ExpDaoImpl();
	}


	@Override
	public List<Showthoughts> showHisExp(int userid) {
		// TODO Auto-generated method stub
		return this.expDao.selectById(userid);
	}

}
