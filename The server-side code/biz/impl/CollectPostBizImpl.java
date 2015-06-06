package com.active.school.biz.impl;

import java.util.List;

import com.active.school.biz.ICollectPostBiz;
import com.active.school.dao.ICollectPostsDao;
import com.active.school.dao.impl.CollectPostsDaoImpl;
import com.active.school.po.Collectposts;
import com.active.school.vo.Showcollectposts;

public class CollectPostBizImpl implements ICollectPostBiz {
	
	private ICollectPostsDao collectpostsDao;
	
	

	public CollectPostBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.collectpostsDao = new CollectPostsDaoImpl();
	}



	@Override
	public boolean CollectPost(Collectposts collectpost) {
		// TODO Auto-generated method stub
		return this.collectpostsDao.insert(collectpost)>0?true:false;
	}



	@Override
	public boolean CancelCollect(int userid, int pid) {
		// TODO Auto-generated method stub
		return this.collectpostsDao.delete(userid, pid)>0?true:false;
	}



	@Override
	public List<Showcollectposts> FindCollectposts(int userid) {
		// TODO Auto-generated method stub
		return this.collectpostsDao.selectAll(userid);
	}

}
