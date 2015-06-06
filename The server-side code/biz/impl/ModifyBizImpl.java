package com.active.school.biz.impl;

import com.active.school.biz.IModifyBiz;
import com.active.school.dao.IUsersDao;
import com.active.school.dao.impl.UsersDaoImpl;
import com.active.school.po.Users;

public class ModifyBizImpl implements IModifyBiz {

	private IUsersDao usersDao;
	public ModifyBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
	}



	@Override
	public boolean modify(Users user) {
		// TODO Auto-generated method stub
		return this.usersDao.update(user)>0?true:false;
	}

}
