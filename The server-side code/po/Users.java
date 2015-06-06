package com.active.school.po;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Users implements Serializable {
	int userid;
	String account;
	String password;
	String nickname;
	String gender;
	String college;
	String context;
	String Statement;
	Date time;
	int usercondition;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getStatement() {
		return Statement;
	}
	public void setStatement(String statement) {
		Statement = statement;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getUsercondition() {
		return usercondition;
	}
	public void setUsercondition(int usercondition) {
		this.usercondition = usercondition;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int userid, String account, String password, String nickname,
			String gender, String college, String context, String statement,
			Date time, int usercondition) {
		super();
		this.userid = userid;
		this.account = account;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.college = college;
		this.context = context;
		Statement = statement;
		this.time = time;
		this.usercondition = usercondition;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", account=" + account
				+ ", password=" + password + ", nickname=" + nickname
				+ ", gender=" + gender + ", college=" + college + ", context="
				+ context + ", Statement=" + Statement + ", time=" + time
				+ ", usercondition=" + usercondition + "]";
	}

}
