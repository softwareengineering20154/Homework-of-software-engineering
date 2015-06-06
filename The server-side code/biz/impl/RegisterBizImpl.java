package com.active.school.biz.impl;

import com.active.school.biz.IRegisterBiz;
import com.active.school.dao.IUsersDao;
import com.active.school.dao.impl.UsersDaoImpl;
import com.active.school.po.Users;

public class RegisterBizImpl implements IRegisterBiz {

private IUsersDao usersDao;
	
	
	
	public RegisterBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
	}



	@Override
	public boolean register(Users user) {
		// TODO Auto-generated method stub
		return this.usersDao.insert(user)>0?true:false;
	}

}
