package com.active.school.biz.impl;

import java.util.List;

import com.active.school.biz.IShowfriendsBiz;
import com.active.school.dao.IFriendsDao;
import com.active.school.dao.impl.FriendsDaoImpl;
import com.active.school.vo.Friends;

public class ShowfriendsBizImpl implements IShowfriendsBiz {
	private IFriendsDao friendsDao ;
	
	

	public ShowfriendsBizImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.friendsDao= new FriendsDaoImpl();
	}



	@Override
	public List<Friends> FindFriends(int userid) {
		// TODO Auto-generated method stub
		 return this.friendsDao.selectFriends(userid);
	}

}
