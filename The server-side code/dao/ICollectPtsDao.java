package com.active.school.dao;

import java.util.List;

import com.active.cate.po.Collectposts;
import com.active.cate.vo.Showcollectposts;

public interface ICollectPostsDao {
	
	public abstract int insert(final Collectposts collectpost);
	public abstract int delete (final int userid,final int pid);
	public abstract List<Showcollectposts> selectAll (final int userid);

}
