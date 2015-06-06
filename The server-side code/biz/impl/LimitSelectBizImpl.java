package com.active.school.biz.impl;

import java.util.List;

import com.active.school.biz.ILimitSelectBiz;
import com.active.school.dao.IPostsDao;
import com.active.school.dao.impl.PostsDaoImpl;
import com.active.school.vo.Showposts;

public class LimitSelectBizImpl implements ILimitSelectBiz {

	private IPostsDao postsDao;
	public LimitSelectBizImpl() {
		// TODO Auto-generated constructor stubs
		super();
		this.postsDao = new PostsDaoImpl ();
	}
	@Override
	public List<Showposts> limitSelect(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		return this.postsDao.limitSelect(startRow, pageSize);
	}
	public int selectAll(){
		return this.postsDao.selectAll();
		
	}

}
