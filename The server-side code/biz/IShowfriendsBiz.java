package com.active.school.biz;

import java.util.List;

import com.active.school.vo.Friends;

public interface IShowfriendsBiz {
	public abstract List<Friends> FindFriends(final int userid);
}
