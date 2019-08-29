package com.lanqiao.domain;

public class Wen {
private int uid ;
private int gid ;
private int wen;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getGid() {
	return gid;
}
public Wen(int uid, int gid, int wen) {
	super();
	this.uid = uid;
	this.gid = gid;
	this.wen = wen;
}
public Wen() {
	super();
	// TODO Auto-generated constructor stub
}
public void setGid(int gid) {
	this.gid = gid;
}
public int getWen() {
	return wen;
}
public void setWen(int wen) {
	this.wen = wen;
}
}
