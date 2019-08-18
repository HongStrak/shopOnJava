package com.lanqiao.domain;

public class BaseDomain {
	
	private Integer uid;
	
	private Integer total;

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
		return "BaseDomain [uid=" + uid + ", total=" + total + "]";
	}
	
	
}
