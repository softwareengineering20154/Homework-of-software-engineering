package com.active.school.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Collectpt implements Serializable {
	
	private int collectpostid;
	private int userid;
	private int pid ;
	public Collectpt() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Collectpt(int collectpostid, int userid, int pid) {
		super();
		this.collectpostid = collectpostid;
		this.userid = userid;
		this.pid = pid;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Collectpt [collectpostid=" + collectpostid + ", userid="
				+ userid + ", pid=" + pid + "]";
	}
	
	

}
