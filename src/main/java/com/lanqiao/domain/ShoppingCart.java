package com.lanqiao.domain;

public class ShoppingCart {

	private Integer gid;
	private Integer uid;
	private Integer total;
	private Commodity commodity;

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

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		return "ShoppingCart [gid=" + gid + ", uid=" + uid + ", total=" + total + ", commodity=" + commodity + "]";
	}

}
