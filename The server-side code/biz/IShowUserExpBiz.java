package com.active.school.biz;

import java.util.List;

import com.active.school.po.Exp;
import com.active.school.vo.Showthoughts;

public interface IShowHisExpBiz {
	
	
	public abstract List<Showthoughts> showHisExp(final int userid);

}
