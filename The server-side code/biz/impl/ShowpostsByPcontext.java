package com.active.school.biz.impl;

import java.util.List;

import com.active.school.biz.IShowpostsByContextBiz;
import com.active.school.dao.IPostsDao;
import com.active.school.dao.impl.PostsDaoImpl;
import com.active.school.vo.Showposts;

public class ShowpostsByPcontext implements IShowpostsByContextBiz {
	private IPostsDao postsDao;
	
	public ShowpostsByPcontext() {
		// TODO Auto-generated constructor stubs
		super();
		this.postsDao = new PostsDaoImpl ();
	}

	@Override
	public List<Showposts> findByPcontext(String pcontext) {
		// TODO Auto-generated method stub
		return this.postsDao.selectByPcontext(pcontext);
	}

}
