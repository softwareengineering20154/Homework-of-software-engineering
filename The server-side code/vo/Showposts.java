package com.active.school.vo;

import java.sql.Date;

public class Showposts {

	
	private int pid;
	private int userid;
	private int reid;
	private String pcontext;
	private int followid;
	private Date ptime;
	private String nickname;
	public Showposts() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Showposts(int pid, int userid, int reid, String pcontext,
			int followid, Date ptime, String nickname) {
		super();
		this.pid = pid;
		this.userid = userid;
		this.reid = reid;
		this.pcontext = pcontext;
		this.followid = followid;
		this.ptime = ptime;
		this.nickname = nickname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getReid() {
		return reid;
	}
	public void setReid(int reid) {
		this.reid = reid;
	}
	public String getPcontext() {
		return pcontext;
	}
	public void setPcontext(String pcontext) {
		this.pcontext = pcontext;
	}
	public int getFollowid() {
		return followid;
	}
	public void setFollowid(int followid) {
		this.followid = followid;
	}
	public Date getPtime() {
		return ptime;
	}
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Showposts [pid=" + pid + ", userid=" + userid + ", reid="
				+ reid + ", pcontext=" + pcontext + ", followid=" + followid
				+ ", ptime=" + ptime + ", nickname=" + nickname + "]";
	}
	
}
