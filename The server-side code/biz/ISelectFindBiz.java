package com.active.school.biz;

import java.util.List;

import com.active.school.po.Goods;
import com.active.school.po.Users;

public interface ISelectFindBiz {
	public abstract List<Users> selectUserbyName(final String nickname); 
	public abstract List<Users> selectUserbyCol(final String college); 
	public abstract List<Food> selectGoodsbyName(final String name); 
	public abstract List<Food> selectGoodsbyKind(final String kind); 
	public abstract Users selectUserbyId(final int userid);

}
