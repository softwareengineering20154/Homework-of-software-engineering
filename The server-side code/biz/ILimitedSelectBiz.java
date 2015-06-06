package com.active.school.biz;

import java.util.List;

import com.active.school.vo.Showposts;

public interface ILimitSelectBiz {
	public abstract List <Showposts> limitSelect(final int startRow, final int pageSize);
	public abstract int selectAll();
}
