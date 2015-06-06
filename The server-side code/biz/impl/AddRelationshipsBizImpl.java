package com.active.school.biz.impl;

import com.active.school.biz.IAddRelationshipsBiz;
import com.active.school.dao.IRelationshipsDao;
import com.active.school.dao.impl.RelationshipsDaoImpl;
import com.active.school.po.Relationships;

public class AddRelationshipsBizImpl implements IAddRelationshipsBiz {
	
	private IRelationshipsDao relationshipsDao ;
	

	public AddRelationshipsBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.relationshipsDao = new RelationshipsDaoImpl();
	}


	@Override
	public boolean addRelationships(Relationships relationship) {
		// TODO Auto-generated method stub
		return this.relationshipsDao.insert(relationship)>0?true:false;
	}
	
}
