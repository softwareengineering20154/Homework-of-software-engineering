package com.active.school.dao;

import java.util.List;

import com.active.cate.po.Relationships;


public interface IRelationshipsDao {
	
	public abstract int insert(final Relationships relationship);
	public abstract List<Relationships> selectAll();
	public abstract int deleteById (final int userid,final int friendid);
	public abstract Relationships selectById (final int relationshipid);
	public abstract int update (Relationships relationship);
	public abstract Relationships selectByObject(final int userid,final int friendid);
	
	

}
