package com.active.school.biz.impl;

import com.active.school.biz.ICancelFocusBiz;
import com.active.school.dao.IRelationshipsDao;
import com.active.school.dao.impl.RelationshipsDaoImpl;

public class CancelFocusBizImpl implements ICancelFocusBiz {
	private IRelationshipsDao relationshipsDao ;
	
	

	public CancelFocusBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.relationshipsDao = new RelationshipsDaoImpl();
	}



	@Override
	public boolean cancelFocus(int userid,int friendid) {
		// TODO Auto-generated method stub
		return this.relationshipsDao.deleteById(userid,friendid)>0?true:false;
	}

}
