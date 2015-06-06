package com.active.school.vo;

public class Showcollectposts {
	
	private int collectpostid ;
	private int userid;
	private int pid;
	private String nickname;
	private String pcontext;
	public Showcollectposts() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	public Showcollectposts(int collectpostid, int userid, int pid,
			String nickname, String pcontext) {
		super();
		this.collectpostid = collectpostid;
		this.userid = userid;
		this.pid = pid;
		this.nickname = nickname;
		this.pcontext = pcontext;
	}
	/**
	 * @return the collectpostid
	 */
	public int getCollectpostid() {
		return collectpostid;
	}
	/**
	 * @param collectpostid the collectpostid to set
	 */
	public void setCollectpostid(int collectpostid) {
		this.collectpostid = collectpostid;
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
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
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
	 * @return the pcontext
	 */
	public String getPcontext() {
		return pcontext;
	}
	/**
	 * @param pcontext the pcontext to set
	 */
	public void setPcontext(String pcontext) {
		this.pcontext = pcontext;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Showcollectposts [collectpostid=" + collectpostid + ", userid="
				+ userid + ", pid=" + pid + ", nickname=" + nickname
				+ ", pcontext=" + pcontext + "]";
	}
	
	
	
	
	

}
