package com.active.school.biz.impl;

import com.active.school.biz.ILoginBiz;
import com.active.school.dao.IUsersDao;
import com.active.school.dao.impl.UsersDaoImpl;
import com.active.school.po.Users;

public class LoginBizImpl implements ILoginBiz {

private IUsersDao usersDao;
	
	public LoginBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
	}

	@Override
	public Users isLogin(String account, String password) {
		// TODO Auto-generated method stub
		return this.usersDao.selectByObject(account, password);
	}

}
