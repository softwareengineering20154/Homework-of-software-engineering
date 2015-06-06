package com.active.school.dao;

import java.util.List;

import com.active.cate.vo.Friends;

public interface IFriendsDao {
	
	
	public abstract List<Friends>deleteFriends(final int userid);
	public abstract List<Friends>InsertFriends(final int userid);
	public abstract List<Friends>selectFriends(final int userid);

}
