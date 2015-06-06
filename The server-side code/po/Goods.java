package com.active.school.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class goods implements Serializable {
	int goodsid;
	String fname;
	String expplace;
	String kind;
	double price;
	int number;
	int grade;
	public int getgoodsid() {
		return goodsid;
	}
	public void setgoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getExpplace() {
		return expplace;
	}
	public void setExpplace(String expplace) {
		this.expplace = expplace;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "goods [goodsid=" + goodsid + ", fname=" + fname + ", expplace="
				+ expplace + ", kind=" + kind + ", price=" + price
				+ ", number=" + number + ", grade=" + grade + "]";
	}
	public goods(int goodsid, String fname, String expplace, String kind,
			double price, int number, int grade) {
		super();
		this.goodsid = goodsid;
		this.fname = fname;
		this.expplace = expplace;
		this.kind = kind;
		this.price = price;
		this.number = number;
		this.grade = grade;
	}
	public goods() {
		super();
		// TODO Auto-generated constructor stub
	}

}
