package com.active.school.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Exp implements Serializable {

	private int expid;
	private int userid;
	private String satify;
	private String expplace;
	private String thoughts;
	public Exp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exp(int expid, int foodid, int userid, String satify, String expplace,
			String foodname, String thoughts) {
		super();
		this.expid = expid;
		this.foodid = foodid;
		this.userid = userid;
		this.satify = satify;
		this.expplace = expplace;
		this.foodname = foodname;
		this.thoughts = thoughts;
	}
	public int getExpid() {
		return expid;
	}
	public void setExpid(int expid) {
		this.expid = expid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSatify() {
		return satify;
	}
	public void setSatify(String satify) {
		this.satify = satify;
	}
	public String getExpplace() {
		return expplace;
	}
	public void setExpplace(String expplace) {
		this.expplace = expplace;
	}
	public String getThoughts() {
		return thoughts;
	}
	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}
	@Override
	public String toString() {
		return "Exp [expid=" + expid + ", userid="
				+ userid + ", satify=" + satify + ", expplace=" + expplace
				+ ", thoughts=" + thoughts + "]";
	}
	
}