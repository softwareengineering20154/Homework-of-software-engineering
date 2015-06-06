package com.active.school.biz;

import java.util.List;

import com.active.school.vo.Showposts;

public interface IShowpostsByNicknameBiz {
	
	public abstract List <Showposts> findByNickname (final String nickname);

}
