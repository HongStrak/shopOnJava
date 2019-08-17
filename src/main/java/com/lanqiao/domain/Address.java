package com.lanqiao.domain;

/** 地址表Javabean */
public class Address {
	
	/**地址id*/
	private Integer id;
	
	/** 用户id */
	private Integer uid;
	/** 收货地址 */
	private String address;
	/** 是否为默认收货地址 */
	private String isDefaultAddr;

	public Address() {
		super();

	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getUid() {
		return uid;
	}



	public void setUid(Integer uid) {
		this.uid = uid;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsDefaultAddr() {
		return isDefaultAddr;
	}

	public void setIsDefaultAddr(String isDefaultAddr) {
		this.isDefaultAddr = isDefaultAddr;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", address=" + address + ", isDefaultAddr=" + isDefaultAddr + "]";
	}

	
}
