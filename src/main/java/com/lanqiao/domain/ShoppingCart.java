package com.lanqiao.domain;

public class ShoppingCart {
	
	private Integer gid;
	private Integer uid;
	private Integer total;
	
	

	public Integer getGid() {
		return gid;
	}



	public void setGid(Integer gid) {
		this.gid = gid;
	}



	public Integer getUid() {
		return uid;
	}



	public void setUid(Integer uid) {
		this.uid = uid;
	}



	public Integer getTotal() {
		return total;
	}



	public void setTotal(Integer total) {
		this.total = total;
	}



	@Override
	public String toString() {
		return "ShoppingCart [gid=" + gid + ", uid=" + uid + ", total=" + total + "]";
	}
	
	

}
