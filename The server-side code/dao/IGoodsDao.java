package com.active.school.dao;

import java.util.List;

import com.active.cate.po.Goods;

public interface IGoodsDao {
	public abstract int insert(final Goods goods);
	public abstract List<Goods> selectAll();//    admin
	public abstract int deleteById(final int cusid);//     admin
	public abstract Goods selectById(final int cusid);
	public abstract List<Goods> selectByFname(final String fname);
	public abstract int update(final Goods customer);
	public abstract List<Goods> selectBykind(final String kind);
	public abstract int[] countAll();

}
