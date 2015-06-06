package com.active.school.biz;

import java.util.List;

import com.active.school.po.Posts;
import com.active.school.vo.Showposts;

public interface IUppostBiz {
	
	public abstract boolean upPost(final Posts post);
	public abstract List <Showposts> findAll ( final int followid);
	

}
