package com.active.school.biz.impl;

import java.util.List;

import com.active.school.biz.IUppostBiz;
import com.active.school.dao.IPostsDao;
import com.active.school.dao.impl.PostsDaoImpl;
import com.active.school.po.Posts;
import com.active.school.vo.Showposts;

public class UppostBizImpl implements IUppostBiz {
	private IPostsDao postsDao;
	
	

	public UppostBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.postsDao = new PostsDaoImpl ();
		
	}



	@Override
	public  boolean upPost(Posts post) {
		// TODO Auto-generated method stub
		return this.postsDao.insert(post)>0?true:false;
	}



	@Override
	public List<Showposts> findAll(int followid) {
		// TODO Auto-generated method stub
		return this.postsDao.selectByFollowid(followid);
	}


}
