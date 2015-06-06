package com.active.school.dao;

import java.util.List;

import com.active.cate.po.Posts;
import com.active.cate.vo.Showposts;

public interface IPostsDao {
	public abstract int insert (final Posts post);
	public abstract List<Showposts> selectByFollowid(final int followid);
	public abstract int deleteById (final int pid);
	public abstract Posts selectById (final int pid);
	public abstract List<Showposts> selectByNickname(final String nickname);
	public abstract List<Showposts> selectByPcontext(final String pcontext);
	public abstract int update (final Posts post);	
	public abstract List<Showposts> limitSelect(final int startRow, final int pageSize);
	public abstract int selectAll();

}
