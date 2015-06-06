package com.active.school.biz;

import com.active.school.po.Users;

public interface ILoginBiz {
	public abstract Users isLogin(final String account, final String password);

}
