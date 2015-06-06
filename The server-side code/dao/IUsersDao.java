package com.active.school.dao;

import java.util.List;

import com.active.cate.po.Users;



public interface IUsersDao {
	public abstract int insert(final Users users);
	public abstract List<Users> selectAll();//    admin
	public abstract int deleteById(final int userid);//     admin
	public abstract Users selectById(final int userid);
	public abstract List<Users> selectByName(final String nickname);
	public abstract int update(final Users users);
	public abstract Users selectByObject(final String account, final String password);
	public abstract List<Users> selectByCollege(final String college);

}
