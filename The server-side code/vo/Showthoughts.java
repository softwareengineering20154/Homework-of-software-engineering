package com.active.school.vo;

public class Showthoughts {
	private int expid;
	private int userid;
	private String nickname;
	private String thoughts;
	private String expplace;
	private String satify;
	public Showthoughts() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Showthoughts(int expid, int userid, String nickname,
			String thoughts, String foodname, String expplace, String satify) {
		super();
		this.expid = expid;
		this.userid = userid;
		this.nickname = nickname;
		this.thoughts = thoughts;
		this.expplace = expplace;
		this.satify = satify;
	}
	/**
	 * @return the expid
	 */
	public int getExpid() {
		return expid;
	}
	/**
	 * @param expid the expid to set
	 */
	public void setExpid(int expid) {
		this.expid = expid;
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the thoughts
	 */
	public String getThoughts() {
		return thoughts;
	}
	/**
	 * @param thoughts the thoughts to set
	 */
	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}
	/**
	 * @return the expplace
	 */
	public String getExpplace() {
		return expplace;
	}
	/**
	 * @param expplace the expplace to set
	 */
	public void setExpplace(String expplace) {
		this.expplace = expplace;
	}
	/**
	 * @return the satify
	 */
	public String getSatify() {
		return satify;
	}
	/**
	 * @param satify the satify to set
	 */
	public void setSatify(String satify) {
		this.satify = satify;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Showthoughts [expid=" + expid + ", userid=" + userid
				+ ", nickname=" + nickname + ", thoughts=" + thoughts
				+ ", expplace=" + expplace
				+ ", satify=" + satify + "]";
	}
	
	

	
	

}
