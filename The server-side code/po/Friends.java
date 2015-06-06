package com.active.school.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Friends implements Serializable {
	
	private int relationshipid;
	private int userid;
	private int friendid;
	private String nickname;
	private String fnickname;
	public Friends() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	public Friends(int relationshipid, int userid, int friendid,
			String nickname, String fnickname) {
		super();
		this.relationshipid = relationshipid;
		this.userid = userid;
		this.friendid = friendid;
		this.nickname = nickname;
		this.fnickname = fnickname;
	}
	public int getRelationshipid() {
		return relationshipid;
	}
	public void setRelationshipid(int relationshipid) {
		this.relationshipid = relationshipid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getFnickname() {
		return fnickname;
	}
	public void setFnickname(String fnickname) {
		this.fnickname = fnickname;
	}
	@Override
	public String toString() {
		return "Friends [relationshipid=" + relationshipid + ", userid="
				+ userid + ", friendid=" + friendid + ", nickname=" + nickname
				+ ", fnickname=" + fnickname + "]";
	}
	

	
	

}
