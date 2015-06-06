package com.active.school.vo;

public class Friends {
	
	private int relationshipid;
	private int userid;
	private int friendid;
	private String nickname;
	private String fnickname;
	private String college;
	private String gender;
	public Friends() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friends(int relationshipid, int userid, int friendid,
			String nickname, String fnickname, String college, String gender) {
		super();
		this.relationshipid = relationshipid;
		this.userid = userid;
		this.friendid = friendid;
		this.nickname = nickname;
		this.fnickname = fnickname;
		this.college = college;
		this.gender = gender;
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Friends [relationshipid=" + relationshipid + ", userid="
				+ userid + ", friendid=" + friendid + ", nickname=" + nickname
				+ ", fnickname=" + fnickname + ", college=" + college
				+ ", gender=" + gender + "]";
	}
	
	
	
	
	

}
