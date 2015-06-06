package com.active.school.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Relationships implements Serializable {
	
	private int relationshipid;
	private int userid;
	private int friendid;

	public Relationships() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	public Relationships(int relationshipid, int userid, int friendid,
			String nickname, String fnickname) {
		super();
		this.relationshipid = relationshipid;
		this.userid = userid;
		this.friendid = friendid;
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
	@Override
	public String toString() {
		return "Relationships [relationshipid=" + relationshipid + ", userid="
				+ userid + ", friendid=" + friendid + "]";
	}



	
	

}
