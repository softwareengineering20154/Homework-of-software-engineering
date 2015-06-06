package com.active.school.biz.impl;

import com.active.school.biz.IUpreplyBiz;
import com.active.school.dao.IPostsDao;
import com.active.school.dao.impl.PostsDaoImpl;
import com.active.school.po.Posts;

public class UpreplyBizImpl implements IUpreplyBiz {
	
	private IPostsDao postsDao;
	
	

	public UpreplyBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.postsDao = new PostsDaoImpl();
	}



	@Override
	public boolean upReply(Posts post) {
		// TODO Auto-generated method stub
		return this.postsDao.insert(post)>0?true:false;
	}





}
