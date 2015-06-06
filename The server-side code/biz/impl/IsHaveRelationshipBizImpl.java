package com.active.school.biz.impl;

import com.active.school.biz.IIsRelationshipExistBiz;
import com.active.school.dao.IRelationshipsDao;
import com.active.school.dao.impl.RelationshipsDaoImpl;
import com.active.school.po.Relationships;

public class IsRelationshipExistBizImpl implements IIsRelationshipExistBiz {
	
	private IRelationshipsDao relationshipsDao;
	
	

	public IsRelationshipExistBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.relationshipsDao = new RelationshipsDaoImpl();
		
	}



	@Override
	public Relationships isExist(int userid, int friendid) {
		// TODO Auto-generated method stub
		return this.relationshipsDao.selectByObject(userid, friendid);
	}

}
