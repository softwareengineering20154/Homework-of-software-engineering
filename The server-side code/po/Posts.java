package com.active.school.po;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Posts implements Serializable {
	private int pid;
	private int userid;
	private int reid;
	private String pcontext;
	private int followid;
	private Date ptime;
	
	public Posts() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Posts(int pid, int userid, int reid, String pcontext, int followid,
			Date ptime, int isCollected) {
		super();
		this.pid = pid;
		this.userid = userid;
		this.reid = reid;
		this.pcontext = pcontext;
		this.followid = followid;
		this.ptime = ptime;
	
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
	 * @return the reid
	 */
	public int getReid() {
		return reid;
	}
	/**
	 * @param reid the reid to set
	 */
	public void setReid(int reid) {
		this.reid = reid;
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
	/**
	 * @return the followid
	 */
	public int getFollowid() {
		return followid;
	}
	/**
	 * @param followid the followid to set
	 */
	public void setFollowid(int followid) {
		this.followid = followid;
	}
	/**
	 * @return the ptime
	 */
	public Date getPtime() {
		return ptime;
	}
	/**
	 * @param ptime the ptime to set
	 */
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Posts [pid=" + pid + ", userid=" + userid + ", reid=" + reid
				+ ", pcontext=" + pcontext + ", followid=" + followid
				+ ", ptime=" + ptime + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
 
}
