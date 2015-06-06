package com.active.school.dao;

import java.util.List;

import com.active.cate.po.Exp;
import com.active.cate.vo.Showthoughts;

public interface IExpDao {

	public abstract List<Showthoughts> selectAll();
	public abstract int insert(final Exp exp);
	public abstract List<Showthoughts> selectById (final int userid);
	public abstract List<Exp> selectall();
}
