package com.active.school.biz;

import com.active.school.po.Relationships;

public interface IIsRelationshipExistBiz {
	
	public abstract Relationships isExist(final int userid ,final int friendid);
	
	
	

}
