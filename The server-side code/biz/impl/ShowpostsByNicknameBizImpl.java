package com.active.school.biz.impl;

import java.util.List;

import com.active.school.biz.IShowpostsByNicknameBiz;
import com.active.school.dao.IPostsDao;
import com.active.school.dao.impl.PostsDaoImpl;
import com.active.school.vo.Showposts;

public class ShowpostsByNicknameBizImpl implements IShowpostsByNicknameBiz {
	
	private IPostsDao postsDao;

	
	
	public ShowpostsByNicknameBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.postsDao = new PostsDaoImpl ();
	}



	@Override
	public List<Showposts> findByNickname(String nickname) {
		// TODO Auto-generated method stub
		return this.postsDao.selectByNickname(nickname);
	}

}
