package com.active.school.biz.impl;

import java.util.List;

import com.active.school.biz.ISelectFindBiz;
import com.active.school.dao.IFoodDao;
import com.active.school.dao.IUsersDao;
import com.active.school.dao.impl.FoodDaoImpl;
import com.active.school.dao.impl.UsersDaoImpl;
import com.active.school.po.Food;
import com.active.school.po.Users;

public class SelectFindBizImpl implements ISelectFindBiz {

	private IUsersDao usersDao;
	private IFoodDao foodDao;
	
	public SelectFindBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
		this.foodDao = new FoodDaoImpl();
	}
	@Override
	public List<Users> selectUserbyName(String nickname) {
		// TODO Auto-generated method stub
		return this.usersDao.selectByName(nickname);
	}

	@Override
	public List<Users> selectUserbyCol(String college) {
		// TODO Auto-generated method stub
		return this.usersDao.selectByCollege(college);
	}

	@Override
	public List<Food> selectFoodbyName(String fname) {
		// TODO Auto-generated method stub
		return this.foodDao.selectByFname(fname);
	}

	@Override
	public List<Food> selectFoodbyKind(String kind) {
		// TODO Auto-generated method stub
		return this.foodDao.selectBykind(kind);
	}
	public Users selectUserbyId(int userid) {
		// TODO Auto-generated method stub
		return this.usersDao.selectById(userid);
	}
}
