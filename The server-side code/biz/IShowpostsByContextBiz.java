package com.active.school.biz;

import java.util.List;

import com.active.school.vo.Showposts;

public interface IShowpostsByContextBiz {
	
	public abstract List <Showposts> findByPcontext (final String pcontext);

}
