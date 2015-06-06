package com.active.school.biz;

import java.util.List;

import com.active.school.po.Collectposts;
import com.active.school.vo.Showcollectposts;

public interface ICollectPostBiz {
	
	public abstract boolean CollectPost (Collectposts collectpost);
	public abstract boolean CancelCollect(int userid,int pid);
	public abstract List<Showcollectposts> FindCollectposts(int userid);

}
