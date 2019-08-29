package com.lanqiao.domain;

public class Recommend {
	private int uid;
	private int gid;
	private double wen;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public double getWen() {
		return wen;
	}
	public void setWen(double wen) {
		this.wen = wen;
	}
	public Recommend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recommend(int uid, int gid, double wen) {
		super();
		this.uid = uid;
		this.gid = gid;
		this.wen = wen;
	}
	
	
	
}
